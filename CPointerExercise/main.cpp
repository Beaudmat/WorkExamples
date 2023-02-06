#include <iostream>
#include <cstring>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int length(char *string){
	int n = 0;
	while(*string++ != '\0') n++;
	return n;
}

void power(int *value, int *raise){
	int result = 1;	
	for(int i = 0; i < (*raise); i++){
		result *= (*value);
	}
	(*value) = result;
}


typedef struct{
	char firstName[8];
	char lastName[9];
	char middleInital;	
}Name;

typedef struct{
	Name name;
	int id_num;
}ID;

int main(int argc, char** argv) {
	
	//Collects string and outputs length
	printf("EXERCISE 1\n\n");

	char input[20];

	printf("Please enter a string: ");
	scanf("%s", &input);
	printf("%d\n\n", length(input));
	
	//Prints out the power of two numbers
	printf("EXERCISE 2\n\n");

	int a = 2;
	int b = 3;

	power(&a, &b);
	printf("a to the b is %d\n\n", a);
	
	//places values inside of a struct then prints them
	printf("EXERCISE 3\n\n");
	ID id_value;
	ID *id_ptr;
	id_ptr = &id_value;
	Name name_value;
	Name *name_ptr;
	name_ptr = &name_value;
	strcpy(name_ptr -> firstName, "Velma");
	strcpy(name_ptr -> lastName, "Dinkley");
	name_ptr -> middleInital = 'D';
	id_ptr -> name = *name_ptr;
	printf("%s %c %s\n", id_ptr->name.firstName, id_ptr->name.middleInital, id_ptr->name.lastName);
	
	return 0;
}
