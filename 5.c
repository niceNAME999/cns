#include<stdio.h>
int IP[] = {2,6,3,1,4,8,5,7};
int IPINV[] = {4,1,3,5,7,2,8,6};

int s0[4][4] = {{1, 0, 3, 2}, {3, 2, 1, 0}, {0, 2, 1, 3}, {3, 1, 3, 2}};
int s1[4][4] = {{0, 1, 2, 3}, {3, 2, 0, 1}, {3, 1, 3, 2}, {2, 0, 1, 3}};

int ip(int pt){
    int r = 0 ;
    for (int i = 0; i < 8; i++)
    {
        r|= ((pt>>(8-IP[i]))&1)<<(7-i);
    }
    return r;
}

int iip(int ct){
    int r = 0 ;
    for (int i = 0; i < 8; i++)
    {
         r|= ((ct>>(8-IPINV[i]))&1)<<(7-i);
    }
    return r;
}

int sboxres(int value , int s[4][4]){
    int row = ((value & 0b1000)>>2) |( value & 0b0001) ;
    int col = (value & 0b0110) >>1; 
    return s[row][col];
}

int main(){
    int pt = 0b11010110;
    printf("pt : %x\n",pt);
    int ct = ip(pt);
    printf("ct : %x\n",ct);
    int sboxressult = sboxres(0b1101 , s0);
    printf("s : %x\n",sboxressult);
    int dt = iip(ct);
    printf("dt : %x\n",dt);
    return 0;
}