#include<stdio.h>
#include<stdlib.h>


int main(void) {

	int M, N, K, R, x, y, z, a, b, c, e, s, w, n;
	R = 0;
	x = 0;
	y = 0;
	z = 0;
	a = 0;
	b = 0;
	c = 0;
	e = 0;
	s = 0;
	w = 0;
	n = 0;

	/*
	printf("M: ");
	*/
	scanf("%d %d %d", &M, &N, &K);
	/*
	printf("N: ");
	scanf_s("%d", &N);
	printf("K: ");
	scanf_s("%d", &K);
	*/

	int **array;
	array = (int**)malloc(M * sizeof(int*));
	for (int i = 0; i < M; i++) {
		array[i] = (int*)malloc(N * sizeof(int));
	}

	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			array[i][j] = 0;
		}
	}


	/*
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			printf("%d ", array[i][j]);
		}
		printf("\n");
	}
	*/

	
	int *Location;
	Location = (int*)malloc(K * sizeof(int));

	for (int i = 0; i < K; i++) {
		Location[i] = 0;
	}
	x = 0;
	a = 0;
	b = 0;
	while (x < K) {
		scanf("%d %d", &a, &b);
		array[a-1][b-1] = 1;
		x++;
	}

	/*
	srand(time(NULL));

	x = 0;
	for (int i = 0; i < K; i++) {
		while (x == 0) {
			R = (rand() % (M*N));
			Location[i] = R;
			if (i == 0) {
				break;
			}
			else {
				for (int j = 0; j < i; j++) {
					if (Location[i] != Location[j]) {
						x = 1;
					}
					else {
						x = 0;
						break;
					}
				}
			}
		}
		x = 0;
	}
	*/

	/*
	for (int i = 0; i < K; i++) {
		printf("%d ", Location[i]);
	}
	*/

	/*
	for (int i = 0; i < K; i++) {
		a = Location[i] / N;
		b = Location[i] % N;
		array[a][b] = 1;
	}
	*/
	/*
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			printf("%d ", array[i][j]);
		}
		printf("\n");
	}
	*/


	int *branch_i;
	branch_i = (int *)malloc(K * sizeof(int));
	for (int i = 0; i < K; i++) {
		branch_i[i] = 0;
	}
	int *branch_j;
	branch_j = (int *)malloc(K * sizeof(int));
	for (int i = 0; i < K; i++) {
		branch_j[i] = 0;
	}
	int *mass;
	mass = (int *)malloc(K * sizeof(int));
	for (int i = 0; i < K; i++) {
		mass[i] = 0;
	}

	c = 0;
	x = 0;
	y = 0;
	z = 0;
	e = 0;
	s = 0;
	w = 0;
	n = 0;
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (array[i][j] == 1) {
				a = i;
				b = j;
				array[i][j] = 0;
				z = 1;
				while (1) {
					x = 0;
					if (j + e - w + 1 < N) {
						if (array[i + s - n][j + e - w + 1] == 1) {
							x++;
						}
					}
					if (i + s - n + 1 < M) {
						if (array[i + s - n + 1][j + e - w] == 1) {
							x++;
						}
					}
					if (j + e - w - 1 >= 0) {
						if (array[i + s - n][j + e - w - 1] == 1) {
							x++;
						}
					}
					if (i + s - n - 1 >= 0) {
						if (array[i + s - n - 1][j + e - w] == 1) {
							x++;
						}
					}
					if (x > 1) {
						branch_i[y] = i + s - n;
						branch_j[y] = j + e - w;
						y++;
					}
					if (j + e - w + 1 < N) {
						if (array[i + s - n][j + e - w + 1] == 1) {
							z++;
							array[i + s - n][j + e - w + 1] = 0;
							e++;
							continue;
						}
					}
					if (i + s - n + 1 < M) {
						if (array[i + s - n + 1][j + e - w] == 1) {
							z++;
							array[i + s - n + 1][j + e - w] = 0;
							s++;
							continue;
						}
					}
					if (j + e - w - 1 >= 0) {
						if (array[i + s - n][j + e - w - 1] == 1) {
							z++;
							array[i + s - n][j + e - w - 1] = 0;
							w++;
							continue;
						}
					}
					if (i + s - n - 1 >= 0) {
						if (array[i + s - n - 1][j + e - w] == 1) {
							z++;
							array[i + s - n - 1][j + e - w] = 0;
							n++;
							continue;
						}
					}
					if (y > 0) {
						y--;
						i = branch_i[y];
						j = branch_j[y];
						e = 0;
						s = 0;
						w = 0;
						n = 0;
						continue;
					}
					mass[c] = z;
					c++;
					for (int i = 0; i < K; i++) {
						branch_i[i] = 0;
					}
					for (int i = 0; i < K; i++) {
						branch_j[i] = 0;
					}
					e = 0;
					s = 0;
					w = 0;
					n = 0;
					i = a;
					j = b;
					break;
				}
			}
		}
	}

	x = 0;
	for (int i = 0; i < c; i++) {
		if (x < mass[i]) {
			x = mass[i];
		}
	}

	printf("%d ", x);

	/*
	system("pause");
	*/

	free(branch_j);

	free(branch_i);

	free(Location);

	for (int i = 0; i < M; i++) {
		free(array[i]);
	}
	free(array);

	return 0;
}