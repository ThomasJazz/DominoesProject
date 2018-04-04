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

class CDomino : public CRandom{
	public:
		CDomino(){}  // constructor
		~CDomino(){} // destructor

		struct data_domino{
			int right, left, available;
		};
		deque<data_domino> myDomino;
		void API(void){
			set_availability_onCreate();
		}

	private:
		// EXAMPLE: INHERITANCE - FOR DIFFERENT CLASSES INTERFACE
		void set_availability_onCreate(void){
			data_domino mypiece;
			int rangeLow=0, rangeHigh=1;
			for(int right=0;right<7;right++){
				for(int left=right; left<7;left++){
					mypiece.right=right;
					mypiece.left=left;
					// INHERITANCE - FOR DIFFERENT CLASSES INTERFACE
					mypiece.available=getRandomProtected(rangeLow,rangeHigh);

					cout <<"["<< mypiece.left << "|"<< mypiece.right
							<<"] Status("<< mypiece.available <<")  ";
					myDomino.push_back(mypiece);
				}
				cout << endl;
			}
			cout << "myDomino stores " << (int) myDomino.size() << " pieces.\n";
		}
};

int main(void){

    struct timeval time;
    int i,rangeLow=40, rangeHigh=60, total=30, result;

    gettimeofday(&time, NULL);
    srandom((unsigned int) time.tv_usec);

    // USE PUBLIC METHOD FROM ANYWHERE
    CRandom randOBJ;
    for (i=0; i<total;i++)
    {   result=randOBJ.getRandomPublic(rangeLow, rangeHigh);
        printf("uniform_random = %d \n", result);
    }

    CDomino dominoOBJ;
    dominoOBJ.API();

    return EXIT_SUCCESS;
}

