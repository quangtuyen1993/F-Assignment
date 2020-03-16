/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass.menu;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import ass.model.BaseModel.BaseModel;

/**
 *
 * @author {@link}
 */
public class Util {

	private static Scanner scan;

	public static String inputString(String output) {
		scan = new Scanner(System.in);
		System.out.println(output);
		
		return scan.nextLine();
	}

	public static int inputInt(String output) {
		scan = new Scanner(System.in);
		System.out.println(output);;
		return scan.nextInt();
	}
	
	public static boolean checkInputInList(List<? extends BaseModel>list ,int id){
		boolean check= list.stream().anyMatch(item->item.getId()==id);
		return check;
	}
	public static void getDilivider(int number,int count){
		String rs="----";
		for(int i=0;i<(number+1)*count;i++){
			rs+="-";
		}
		System.out.println(rs);
	}
	public static void getDilivider(int number,String[] listTile){
		String rs="----";
		for(int i=0;i<(number+1)*listTile.length;i++){
			rs+="-";
		}
		System.out.println(rs);
		String title="|%-30.25s |";
		String title2="|%-30.25s |\n";
		for(int i =0;i<listTile.length-1;i++){
			if (i==listTile.length-1) System.out.printf(title2,listTile[i]);
			else System.out.printf(title,listTile[i]);
		}
	}
}
