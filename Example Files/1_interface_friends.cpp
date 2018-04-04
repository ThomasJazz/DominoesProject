#include <iostream>
using namespace std;
#include <iostream>
using namespace std;

class B;     // forward declaration
class A {
    private:
      int data;
    public:
      A(): data(12){ }
      ~A(){}
      //friend friend_functiontion Declaration
      friend int friend_function(A , B);
      int getData(){
    	  return(data);
      }
};

class B {
    private:
       int data;
    public:
       B(): data(1){ }
       ~B(){}
       //friend friend_functiontion Declaration
       friend int friend_function(A , B);
       int getData(){
    	   return(data);
       }
};

int friend_function(A d1,B d2)
{
   return (d1.data+d2.data);
}

int main()
{
	A a;
	B b;
	cout<< "a : " << a.getData() << " b : "
			<< b.getData() << " Data: "<<friend_function(a,b);
	return 0;
}

