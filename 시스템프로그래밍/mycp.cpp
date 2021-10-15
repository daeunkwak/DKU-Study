/*mycp program written by daeunkwak.misodaeun3@naver.com*/
#include <stdlib.h>
#include <unistd.h>	// POSIX �ü�� API�� �����ϴ� ������� 
#include <fcntl.h>	// ������ �ý��ۿ��� ������ ������ �Ӽ��� �������ų� ������ �� ����ϴ� ������� 
#include <errno.h>	// ������ �����Ͽ� errno�� ����Ǵ� ����� �����ϴ� ������� 
#include <sys/types.h>
#include <sys/stat.h>  // struct stat ������� 
#define MAX_BUF 64

int main(int argc, char *argv[]) {
	int org_fd, des_fd, read_size, infoo;
	char buf[MAX_BUF];
	struct stat st;
	
	if (argc != 3){		// ���� ���� �˻� 
		printf("USAGE : %s source_file destination_file\n", argv[0]);
		exit(-1);
	}
	
	org_fd = open(argv[1], O_RDONLY);
	infoo = fstat(org_fd, &st);
	// infoo = st.st_mode;
	if (org_fd < 0) {		// file system error handling
		printf("Can't open! %s\n", argv[1]);
		exit(-1);
	}
	
	// des_fd open
	des_fd = open(argv[2], O_WRONLY | O_CREAT | O_EXCL, st.st_mode &(S_IRWXU | 
	S_IRWXG | S_IRWXO));
	if (des_fd < 0) {
		printf("Can't create %s file with errno %d\n", argv[2], errno);
		exit(-1);
	}
	
	// read_size��ŭ orf_fd������ des_fd�� write 
	while(1) {
		read_size = read(org_fd, buf, MAX_BUF);
		if (read_size == 0) {
			break;
		}
		write(des_fd, buf, read_size);
	}
	close(org_fd);
	close(des_fd);
}




