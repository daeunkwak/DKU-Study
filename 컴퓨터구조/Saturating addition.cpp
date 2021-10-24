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
    printf("���� x�� �Է��ϼ��� : ");
    scanf_s("%d", &x);
    printf("���� y�� �Է��ϼ��� : ");
    scanf_s("%d", &y);
    printf("%d", saturating_add(x, y));
}