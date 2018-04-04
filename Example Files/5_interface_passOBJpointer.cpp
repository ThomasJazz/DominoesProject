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

// MAKE YOUR TYPE DATA A GLOBAL DEFINITION
// IT DOESN'T CREATE A VARIABLE, JUST A DEFINITION OF DATA TYPE
// AS DIFFERENT CLASSES HAS TO COMMUNICATE EASILY
struct data_domino{
	int right, left, available;
};

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
			mypiece.available=0;
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

class CPlayer{
	public:
		CPlayer(){}  // constructor
		~CPlayer(){} // destructor
		deque<data_domino> playerDominoPieces[2];
		class CDomino *player_pDominoOBJ=NULL;

		void API(CDomino *receive_dominoPointerOBJ){
			int pieceID;
			player_pDominoOBJ=receive_dominoPointerOBJ;
			takePiece();
			for(pieceID=0;pieceID<28;pieceID++){
				set_availableALL(pieceID);
			}
		}
		data_domino set_availableALL(int pieceID){
			data_domino mypiece= player_pDominoOBJ->myDomino.at(pieceID);
			cout <<"["<< mypiece.left << "|"<< mypiece.right <<"]"
					<< " available = " << mypiece.available << endl;
			mypiece.available=1;
			player_pDominoOBJ->myDomino.at(pieceID)=mypiece;
			return(mypiece);
		}
	private:
		// PASSING OBJECT AS POINTER - FOR DIFFERENT CLASSES INTERFACE
		void takePiece(void){
			int playerID;
			int totalPlayers=2,counter=0,max=14;
			int pieceNo;

			data_domino takenPiece;
			cout<< "take Piece - one by one"<<endl;
			for(playerID=0;playerID<totalPlayers;playerID++){
				for(pieceNo=counter;pieceNo<max;pieceNo++){
					counter++;
					// PASSING OBJECT AS POINTER - FOR DIFFERENT CLASSES INTERFACE
					takenPiece=player_pDominoOBJ->getPiece(pieceNo);

					cout << "playerID = " << playerID <<"["<< takenPiece.left
							<< "|"<< takenPiece.right <<"]"<< " available = "
							<< takenPiece.available << endl;
					playerDominoPieces[playerID].push_back(takenPiece);
				}
				max+=counter;
			}
		}
}; // END CPlayer

int main(void){

    struct timeval time;
    int pieceID;

    gettimeofday(&time, NULL);
    srandom((unsigned int) time.tv_usec);

    CDomino dominoOBJ,*dominoPointer;
    dominoOBJ.API();
    dominoPointer=&dominoOBJ;

	// EXAMPLE: PASSING OBJECT AS POINTER -
    //          FOR DIFFERENT CLASSES INTERFACE
    CPlayer playerOBJ;
    playerOBJ.API(dominoPointer);

	cout << "check pointer effect on dominoOBJ" << endl;
    for(pieceID=0;pieceID<28;pieceID++){
        dominoOBJ.getPiece(pieceID);
    }

    return EXIT_SUCCESS;
}

