package luxoft.codingchallange.main;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import luxoft.codingchallange.filesystem.File;
import luxoft.codingchallange.filesystem.FileSystem2;

public class Main {

	public static void main(String[] args) {
		// please fill in search criteria
		String searchCriteriaSize = "";
		String searchCriteriaName = "";
		String searchCriteriaTime = "2022-12-03T12:12";
		String searchCriteriaPermissions = "RW";

		boolean searchFlagSize = false;
		boolean searchFlagName = false;
		boolean searchFlagTime = false;
		boolean searchFlagPermissions = false;

		boolean searchOkSize = false;
		boolean searchOkName = false;
		boolean searchOkTime = false;
		boolean searchOkPermissions = false;
		
		boolean flagDisplay = false;
		
		// following code for matrix has to be traversed in reversed diagonal
		// original matrix indexes stored in a map
		int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "0,0");
		map.put(2, "0,1");
		map.put(3, "0,2");
		map.put(4, "1,0");
		map.put(5, "1,1");
		map.put(6, "1,2");
		map.put(7, "2,0");
		map.put(8, "2,1");
		map.put(9, "2,2");
		int retorno[] = findDiagonalOrder(matrix);
		for (int i = 0; i < retorno.length; i++) {
			int matrix_i = Integer.valueOf(map.get(retorno[i]).substring(0, 1));
			int matrix_j = Integer.valueOf(map.get(retorno[i]).substring(2, 3));

			File f1 = FileSystem2.files[matrix_i][matrix_j];
			searchFlagSize = false;
			searchFlagName = false;
			searchFlagTime = false;
			searchFlagPermissions = false;
			searchOkSize = false;
			searchOkName = false;
			searchOkTime = false;
			searchOkPermissions = false;
			if (!searchCriteriaSize.equalsIgnoreCase("")) {
				searchFlagSize = true;
				if (f1.getSize() >= Long.valueOf(searchCriteriaSize)) {
					searchOkSize = true;
				}
			}
			if (!searchCriteriaName.equalsIgnoreCase("")) {
				searchFlagName = true;
				if (f1.getName().contains(searchCriteriaName)) {
					searchOkName = true;
				}
			}
			if (!searchCriteriaTime.equalsIgnoreCase("")) {
				searchFlagTime = true;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd h:m");
				if (f1.getTimeCreated().compareTo(LocalDateTime.parse(searchCriteriaTime)) >= 0) {
					searchOkTime = true;
				}
			}
			if (!searchCriteriaPermissions.equalsIgnoreCase("")) {
				searchFlagPermissions = true;
				if (f1.getPermission().name().equals(searchCriteriaPermissions)) {
					searchOkPermissions = true;
				}
			}

			flagDisplay=false;
      if ( searchFlagSize && searchFlagName   && searchFlagTime  && searchFlagPermissions ) {
	       if ( searchOkSize && searchOkName   && searchOkTime  && searchOkPermissions ) {
	      	 flagDisplay=true;
		 		 }
	    } else if ( searchFlagSize && searchFlagName   && searchFlagTime  && !searchFlagPermissions ) {
      	if ( searchOkSize && searchOkName   && searchOkTime  && !searchOkPermissions ) {
	      	 flagDisplay=true;
      	}
			} else if ( searchFlagSize && searchFlagName   && !searchFlagTime && searchFlagPermissions ) {
				 if ( searchOkSize && searchOkName   && !searchOkTime && searchOkPermissions ) {
	      	 flagDisplay=true;
				 }
			} else if ( searchFlagSize && searchFlagName   && !searchFlagTime && !searchFlagPermissions ) {
				  if ( searchOkSize && !searchOkName  && !searchOkTime  && !searchOkPermissions ) {
		      	 flagDisplay=true;
				  }
			} else if ( searchFlagSize && !searchFlagName  && searchFlagTime  && searchFlagPermissions ) {
				  if ( searchOkSize && !searchOkName  && searchOkTime  && searchOkPermissions ) {
		      	 flagDisplay=true;
				  }
			} else if ( searchFlagSize && !searchFlagName  && searchFlagTime  && !searchFlagPermissions ) {
				  if ( searchOkSize && !searchOkName  && searchOkTime && !searchOkPermissions ) {
		      	 flagDisplay=true;
				  }
			} else if ( searchFlagSize && !searchFlagName  && !searchFlagTime && searchFlagPermissions ) {
				  if ( searchOkSize && !searchOkName  && !searchOkTime && searchOkPermissions ) {
		      	 flagDisplay=true;
				  }
			} else if ( searchFlagSize && !searchFlagName  && !searchFlagTime && !searchFlagPermissions ) {
				  if ( searchOkSize && !searchOkName  && !searchOkTime  && !searchOkPermissions ) {
		      	 flagDisplay=true;
				  }
			} else if ( !searchFlagSize && searchFlagName  && searchFlagTime  && searchFlagPermissions ) {
				  if ( !searchOkSize && searchOkName  && searchOkTime  && searchOkPermissions ) {
		      	 flagDisplay=true;
				  }
			} else if ( !searchFlagSize && searchFlagName  && searchFlagTime  && !searchFlagPermissions ) {
				  if ( !searchOkSize && searchOkName  && searchOkTime && !searchOkPermissions ) {
		      	 flagDisplay=true;
				  }
			} else if ( !searchFlagSize && searchFlagName  && !searchFlagTime && searchFlagPermissions ) {
				  if ( !searchOkSize && searchOkName  && !searchOkTime && searchOkPermissions ) {
		      	 flagDisplay=true;
				  }
			} else if ( !searchFlagSize && searchFlagName  && !searchFlagTime && !searchFlagPermissions ) {
				  if ( !searchOkSize && searchOkName && !searchOkTime  && !searchOkPermissions ) {
		      	 flagDisplay=true;
				  }
			} else if ( !searchFlagSize && !searchFlagName && searchFlagTime  && searchFlagPermissions ) {
				  if ( !searchOkSize && !searchOkName && searchOkTime  && searchOkPermissions ) {
		      	 flagDisplay=true;
				  }
			} else if ( !searchFlagSize && !searchFlagName && searchFlagTime  && !searchFlagPermissions ) {
				  if ( !searchOkSize && !searchOkName && searchOkTime && !searchOkPermissions ) {
		      	 flagDisplay=true;
				  }
			} else if ( !searchFlagSize && !searchFlagName && !searchFlagTime && searchFlagPermissions ) {
				  if ( !searchOkSize && !searchOkName && !searchOkTime && searchOkPermissions ) {
		      	 flagDisplay=true;
				  }
			} else if ( !searchFlagSize && !searchFlagName && !searchFlagTime && !searchFlagPermissions ) {
				  if ( !searchOkSize && !searchOkName && !searchOkTime && !searchOkPermissions ) {
		      	 flagDisplay=true;
				  }
			}   

			if ( flagDisplay){
				System.out.println("Size : " + f1.getSize());
				System.out.println("Name : " + f1.getName());
				System.out.println("Time : " + f1.getTimeCreated());
				System.out.println("Permissions : " + f1.getPermission());
			}

		}

	}

	public static int[] findDiagonalOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return new int[0];
		}
		// Variables to track the size of the matrix
		int N = matrix.length;
		int M = matrix[0].length;
		// The two arrays as explained in the algorithm
		int[] result = new int[N * M];
		int k = 0;
		ArrayList<Integer> intermediate = new ArrayList<Integer>();
		// We have to go over all the elements in the first
		// row and the last column to cover all possible diagonals
		for (int d = 0; d < N + M - 1; d++) {
			// Clear the intermediate array every time we start to process another diagonal
			intermediate.clear();
			// We need to figure out the "head" of this diagonal
			// The elements in the first row and the last column
			// are the respective heads.
			int r = d < M ? 0 : d - M + 1;
			int c = d < M ? d : M - 1;
			// Iterate until one of the indices goes out of scope
			// Take note of the index math to go down the diagonal
			while (r < N && c > -1) {
				intermediate.add(matrix[r][c]);
				++r;
				--c;
			}
			for (int i = 0; i < intermediate.size(); i++) {
				result[k++] = intermediate.get(i);
			}
		}
		return result;
	}
}
