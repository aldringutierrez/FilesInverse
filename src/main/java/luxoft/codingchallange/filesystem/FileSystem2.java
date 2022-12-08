	package luxoft.codingchallange.filesystem;

	import java.time.LocalDateTime;

public class FileSystem2 {
		static int MATRIX_SIZE=3;

	    public static File[][] files = new File[MATRIX_SIZE][MATRIX_SIZE];
	    

	    static {
	        for (int i = 0; i < MATRIX_SIZE; i++) {
	            for (int j = 0; j < MATRIX_SIZE; j++) {

	                long size = 1000 * (i+j);
	                String name = "file" + i + j;
	                final LocalDateTime creationTime = LocalDateTime.of(2022, 12, i+j+1, 12, 12);
	                Permissions permission = Permissions.values()[(10*i+j) % 3];
	                files[i][j] = new File(size, name, creationTime, permission);
	            }
	        }
	    }
	}

	

