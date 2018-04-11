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

// MAKE YOUR TYPE DATA A GLOBAL DEFINITION
// IT DOESN'T CREATE A VARIABLE, JUST A DEFINITION OF DATA TYPE
// AS DIFFERENT CLASSES HAS TO COMMUNICATE EASILY
struct data_domino{
	int right, left, available;
};

class CDomino : public CRandom{
	public:

		CDomino(){}  // constructor
		~CDomino(){} // destructor

		deque<data_domino> myDomino, playerDominoPieces[2];

		void API(void){
			set_availability_onCreate();
		}

		data_domino getPiece(int pieceID){
			data_domino mypiece=myDomino.at(pieceID);
			cout <<"["<< mypiece.left << "|"<< mypiece.right <<"]"
					<< " available = " << mypiece.available << endl;
			mypiece.available=0;
			myDomino.at(pieceID)=mypiece;

			return(mypiece);
		}

	protected:

		// EXAMPLE: HAS OBJECT - FOR DIFFERENT CLASSES INTERFACE
		void set_availability_onCreate(void){
			data_domino mypiece;
			int rangeLow=0, rangeHigh=1;
			for(int right=0;right<7;right++){
				// this loop fills the left and right data for each domino
				for(int left=right; left<7;left++){
					mypiece.right=right;
					mypiece.left=left;
					// HAS OBJECT - FOR DIFFERENT CLASSES INTERFACE
					mypiece.available=1;//has_randOBJ.getRandomPublic(rangeLow, rangeHigh);

					cout <<"["<< mypiece.left << "|"<< mypiece.right <<"] Status("<< mypiece.available <<")  ";
					myDomino.push_back(mypiece);
				}
				cout << endl;
			}

			cout << "myDomino stores " << (int) myDomino.size() << " pieces.\n";
		}
	private:

	    CRandom has_randOBJ;

};

class CPlayer : public CRandom{
	public:
		CPlayer(){}  // constructor
		~CPlayer(){} // destructor
		deque<data_domino> myDomino, playerDominoPieces[2]; // create 2 deque's
		class CDomino player_dominoOBJ; // creates CDomino object

		void API(CDomino receive_dominoOBJ){ // the domino 
			player_dominoOBJ=receive_dominoOBJ; //sets the players domino object to the received parameter
			takePiece(); // call takePiece
		}
	private:
		// PASSING OBJECT AS PARAMETER - FOR DIFFERENT CLASSES INTERFACE
		void takePiece(void){
			int playerID;
			int totalPlayers=2,counter=0,max=14;
			int pieceNo;

			data_domino takenPiece;
			cout<< "take Piece - one by one"<<endl;
			for(playerID=0;playerID<totalPlayers;playerID++){ //runs # of players times
				for(pieceNo=counter;pieceNo<max;pieceNo++){ //runs for each piece
					counter++;
					cout<<"pieceNo = " << pieceNo<<endl;

					// PASSING OBJECT AS PARAMETER - FOR DIFFERENT CLASSES INTERFACE
					takenPiece=player_dominoOBJ.getPiece(pieceNo);

					cout << "playerID = " << playerID <<"["<< takenPiece.left
							<< "|"<< takenPiece.right <<"]"<< " available = "
							<< takenPiece.available << endl;
					playerDominoPieces[playerID].push_back(takenPiece);
				}
				max+=counter;
			}
		}
};

int main(void){

    struct timeval time;

    CDomino dominoOBJ; 
    dominoOBJ.API(); // calls domino version of API

	// EXAMPLE: PASSING OBJECT AS PARAMETER
    //          - FOR DIFFERENT CLASSES INTERFACE
    CPlayer playerOBJ;
    playerOBJ.API(dominoOBJ); // player version of API with dominoOBJ

    return EXIT_SUCCESS;
}

