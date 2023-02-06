#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

typedef struct{
		int width;
		int height;
		int depth;
	} Cube;
	
int calculateVol(int width, int depth, int height){
	return width * height * depth;
}

int main(int argc, char** argv) {
	
	printf("Matthew Beaudoin #########\n\n");
	
	Cube cube;
	
	printf("Enter the cubes width: ");
	scanf("%d",&cube.width);
	printf("Enter the cubes height: ");
	scanf("%d",&cube.height);
	printf("Enter the cubes depth: ");
	scanf("%d",&cube.depth);
	
	printf("The cubes volume is %d meters cubed", calculateVol(cube.width, cube.depth, cube.height));
	
	return 0;
}
