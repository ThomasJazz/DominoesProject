//========================================================================//
//========================================================================//
#include <sys/time.h>
#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <unistd.h>
#include <math.h>
#include <iostream>
#include <deque>
using namespace std;
//========================================================================//
//========================================================================//
// MAKE YOUR TYPE DATA A GLOBAL DEFINITION
// IT DOESN'T CREATE A VARIABLE,
// JUST A DEFINITION OF DATA TYPE
// AS DIFFERENT CLASSES HAS TO COMMUNICATE EASILY
struct data_domino{
	int right, left, available;
};
//========================================================================//
//========================================================================//
class CRandom{
	public:
		CRandom(){}  // constructor
		~CRandom(){} // destructor

		int getRandomPublic(int rangeLow, int rangeHigh){
			int myRand_scaled;

			myRand_scaled=getRandomPrivate(rangeLow, rangeHigh);

		    return myRand_scaled;
		}
	private:
		// Generates uniform distribution between rangeLow and rangeHigh
		int getRandomPrivate(int rangeLow, int rangeHigh) {
		    double myRand = rand()/(1.0 + RAND_MAX);
		    int range = rangeHigh - rangeLow + 1;
		    int myRand_scaled = (myRand * range) + rangeLow;
		    return myRand_scaled;
		}
	protected:
		// Generates uniform distribution between rangeLow and rangeHigh
		int getRandomProtected(int rangeLow, int rangeHigh) {
		    double myRand = rand()/(1.0 + RAND_MAX);
		    int range = rangeHigh - rangeLow + 1;
		    int myRand_scaled = (myRand * range) + rangeLow;
		    return myRand_scaled;
		}

};
//========================================================================//
//========================================================================//
class CDomino{
	public:
		CDomino(){}  // constructor
		~CDomino(){} // destructor
		deque<data_domino> myDomino;
		void API(void){
			init();
		}
		data_domino getPiece(int pieceID){
			data_domino mypiece=myDomino.at(pieceID);
			cout <<"["<< mypiece.left << "|"<< mypiece.right <<"]"
					<< " available = " << mypiece.available << endl;

			myDomino.at(pieceID)=mypiece;
			return(mypiece);
		}
	private:
		void init(void){
			data_domino mypiece;
			for(int right=0;right<7;right++){
				for(int left=right; left<7;left++){
					mypiece.right=right;
					mypiece.left=left;
					mypiece.available=1;
					cout <<"["<< mypiece.left << "|"<< mypiece.right <<"]"<< "  ";
					myDomino.push_back(mypiece);
				}
				cout << endl;
			}
			cout << "myDomino stores " << (int) myDomino.size() << " pieces.\n";
		}
};
//========================================================================//
//========================================================================//
class CPlayer : public CRandom{
	public:
		CPlayer(){}  // constructor
		~CPlayer(){} // destructor
		deque<data_domino> gotHand;
		class CDomino *player_pDominoOBJ=NULL;
		// PASSING OBJECT AS POINTER - FOR DIFFERENT CLASSES INTERFACE
		void API(CDomino *receive_dominoPointerOBJ){
			int pieceID;
			player_pDominoOBJ=receive_dominoPointerOBJ;
		}
		int takePiece(int pieceNo){
			int playerID;
			int counter=0,max=14, number_wasAvailable=0;

			data_domino takenPiece;
			takenPiece=player_pDominoOBJ->getPiece(pieceNo);

			if(takenPiece.available){
				number_wasAvailable=takenPiece.available;
				takenPiece.available=0; // no longer available from the dominoes pile
				player_pDominoOBJ->myDomino.at(pieceNo)=takenPiece;
				cout << " ["<< takenPiece.left
						<< "|"<< takenPiece.right <<"]"
						      << " just taken - no longer available from pile = "
						<< takenPiece.available << endl;
				takenPiece.available=1; // available on Player's hand
				gotHand.push_back(takenPiece);
			}else{
				cout << "NOT AVAILABLE" << endl;
			}
			return (number_wasAvailable);
		}
};
//========================================================================//
//========================================================================//
class CTable{
	public:
		CTable(){}  // constructor
		~CTable(){} // destructor
		class CPlayer *playerOBJ=NULL;

		void selecting_pieces(){
			int pieceNO,piece_wasAvailable,totalPlayer=2;
			cout << "selecting pieces and giving 12 pieces to each player" << endl;

			for(int playerID=0;playerID<totalPlayer;playerID++){
				for(int i=0; i<12; i++){
					pieceNO=playerOBJ[playerID].getRandomPublic(0,27);
					cout <<" pieceNO : "<< pieceNO << endl;
					piece_wasAvailable=playerOBJ[playerID].takePiece(pieceNO);

					if(piece_wasAvailable){
						cout<< "piece available" << endl;
					}else{
						cout<< "////////////////////////////////////////////////" << endl;
						cout<< "piece not available - try to take a piece again" << endl;
						i--;
					}
				}
			}
		}
		void showPlayerHand(void){
			data_domino showpiece;
			int totalPlayer = 2;
			for(int playerID=0;playerID<totalPlayer;playerID++){
				cout << "playerID = " << playerID << " stores " <<
						playerOBJ[playerID].gotHand.size() << " pieces.\n";
				for(int pieceNo=0; pieceNo<playerOBJ[playerID].gotHand.size(); pieceNo++){
					showpiece=playerOBJ[playerID].gotHand.at(pieceNo);
					cout <<"["<< showpiece.left << "|"<< showpiece.right <<"]"
							<< " available = " << showpiece.available << endl;
				}
			}
		}
		void API(CPlayer *receive_playersOBJ){
			playerOBJ=receive_playersOBJ;

			selecting_pieces();
			showPlayerHand();
		}
}; // END CTable
//========================================================================//
//========================================================================//
int main(void){

    struct timeval time;
    int pieceID;

    gettimeofday(&time, NULL);
    srandom((unsigned int) time.tv_usec);

    CDomino dominoOBJ,*dominoPointer;
    dominoOBJ.API();
    dominoPointer=&dominoOBJ;

	// EXAMPLE: PASSING OBJECT AS A NEW POINTER
    //			- FOR DIFFERENT CLASSES INTERFACE
    CPlayer *playerOBJ;
    playerOBJ=new CPlayer[2];
    playerOBJ[0].API(dominoPointer);
    playerOBJ[1].API(dominoPointer);

    CTable myTableObj;
    myTableObj.API(playerOBJ);

    cout << "check pointer effect on dominoOBJ" << endl;
    for(pieceID=0;pieceID<28;pieceID++){
       dominoOBJ.getPiece(pieceID);
    }
    delete []playerOBJ;
    return EXIT_SUCCESS;
}
//========================================================================//
//========================================================================//

