#include <stdio.h>
#include <limits.h>
int saturating_add(int x, int y) {

    int result = x + y;

    unsigned sign_x = (unsigned)x >> 31;
    unsigned sign_y = (unsigned)y >> 31;
    unsigned sign_result = (unsigned)result >> 31;

    // x>0 y>0 result<0 result=MAX
    (sign_x == 0) && (sign_y == 0) && (sign_result == 1) && (result = INT_MAX);
    // x<0 y<0 result>0 result=MIN
    (sign_x == 1) && (sign_y == 1) && (sign_result == 0) && (result = INT_MIN);

    return result;

}
int main() {
    int x = 0, y = 0;
    printf("정수 x를 입력하세요 : ");
    scanf_s("%d", &x);
    printf("정수 y를 입력하세요 : ");
    scanf_s("%d", &y);
    printf("%d", saturating_add(x, y));
}