#include <stdio.h>

int main() {

    int T;
    scanf("%d", &T);

    int array[T][6];

    for(int i = 0; i < T; i++){
        scanf("%d %d %d %d %d %d", &array[i][0], &array[i][1], &array[i][2], &array[i][3], &array[i][4], &array[i][5]);
    }

    for (int i = 0; i < T; i++) {
        
        int x1, y1, r1, x2, y2, r2;

        x1 = array[i][0];
        y1 = array[i][1];
        r1 = array[i][2];
        x2 = array[i][3];
        y2 = array[i][4];
        r2 = array[i][5];

        if(r2 < r1) {
            int tmpx, tmpy, tmpr;
            tmpx = x2;
            tmpy = y2;
            tmpr = r2;

            x2 = x1;
            y2 = y1;
            r2 = r1;

            x1 = tmpx;
            y1 = tmpy;
            r1 = tmpr;
        }

        if((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) >= r2*r2){

            if((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) > (r2+r1) * (r2+r1)){
                printf("0");
                printf("\n");
                continue;
            }
            
            if((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) == (r2+r1) * (r2+r1)){
                printf("1");
                printf("\n");
                continue;
            }

            if((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) < (r2+r1) * (r2+r1)){
                printf("2");
                printf("\n");
                continue;
            }

        } 
        
        if((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) < r2*r2) {

            if(r2 == r1){
                if((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) == 0){
                printf("-1");
                printf("\n");
                continue;
                } else{
                    printf("2");
                    printf("\n");
                    continue;
                }
            }

            if(r2 != r1) {
                if((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) == 0){
                    printf("0");
                    printf("\n");
                    continue;
                }

                if((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) < (r2-r1)*(r2-r1)){
                    printf("0");
                    printf("\n");
                    continue;
                }

                if((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) == (r2-r1)*(r2-r1)){
                    printf("1");
                    printf("\n");
                    continue;
                } else {
                    printf("2");
                    printf("\n");
                    continue;
                }

            }

        }

    }

    return 0;

}