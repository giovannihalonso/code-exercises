package interviewsExercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortMatrixDiagonally {

//	description
//	
//	A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until reaching the matrix's end. 
//	For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].
//
//	Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
//	
//	Example1 Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
//			Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
//					
//	Example 2:
//	
//		Input: mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
//		Output: [[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]

	
	public static void main(String[] args) {


	}
	
	
	// the main idea here is that index value for each diagonal is i - j or x - y, 
	// with this I store each element of each diangonal in a List, then I sort each list and last I push again each sorted element in each diagonal
	

    public int[][] diagonalSort(int[][] mat) {
        
        int x = mat.length;
        int y = mat[0].length;

        HashMap< Integer, List<Integer> > temMap = new HashMap< Integer, List<Integer> >();

        for( int i = 0; i < x ; i++ ){
            for( int j = 0 ; j < y ; j++  ){
                
                if( temMap.get( i - j ) == null ){
                    temMap.put( i - j , new ArrayList<Integer>()  );
                }

                temMap.get( i - j ).add( mat[i][j] );
            }
        }

        for(  Map.Entry< Integer, List<Integer> > entry : temMap.entrySet() ){
            entry.getValue().sort( Collections.reverseOrder() );
        }

        for( int i = 0; i < x ; i++ ){
            for( int j = 0 ; j < y ; j++  ){
                
                if( !temMap.get( i - j ).isEmpty()   ){
                    mat[i][j] = temMap.get( i - j ).remove(  temMap.get( i - j ).size() - 1  );
                }
            }
        }

        return  mat;

    }
	
}
