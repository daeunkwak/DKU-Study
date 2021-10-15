/*mycp program written by daeunkwak.misodaeun3@naver.com*/
#include <stdlib.h>
#include <unistd.h>	// POSIX 운영체제 API를 제공하는 헤더파일 
#include <fcntl.h>	// 리눅스 시스템에서 열려진 파일의 속성을 가져오거나 설정할 때 사용하는 헤더파일 
#include <errno.h>	// 오류를 감지하여 errno에 저장되는 기능을 제공하는 헤더파일 
#include <sys/types.h>
#include <sys/stat.h>  // struct stat 헤더파일 
#define MAX_BUF 64

int main(int argc, char *argv[]) {
	int org_fd, des_fd, read_size, infoo;
	char buf[MAX_BUF];
	struct stat st;
	
	if (argc != 3){		// 인자 개수 검사 
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
	
	// read_size만큼 orf_fd내용을 des_fd에 write 
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




