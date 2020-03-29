package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//Create a instance of this class and call function getAllocation()
public class spaceAllocation {
    int [][] spacedata;
    int [][] projectdata;
    boolean sameType;
    spaceAllocation(int [][]spacedata,int[][]projectdata){

        this.spacedata=spacedata;
        this.projectdata=projectdata;
    }

    public spaceAllocation() {

    }

    public int[][] getSortedproject() {
        int []store=new int[3];
        for(int i=projectdata.length-1;i>=0;i--){
            for(int j=1;j<=i;j++) {

                if (projectdata[j-1][1] * projectdata[j-1][2] <= projectdata[j][1] * projectdata[j][2]) {
                    store=projectdata[j-1];
                    projectdata[j-1]=projectdata[j];
                    projectdata[j]=store;
                }
            }

        }
        return this.projectdata;


    }

    public int[][] allocateSize(){
        int[][] copy = new int[spacedata.length][spacedata[0].length];
        for (int i = 0; i < copy.length; i++)
            copy[i] = Arrays.copyOf(spacedata[i], spacedata[i].length);

        for(int i =0;i<this.projectdata.length;i++){
            for(int j=0;j<copy.length;j++) {
                if (this.projectdata[i][1] <= copy[j][1] & this.projectdata[i][2] <= copy[j][2]) {
                    this.projectdata[i][0] = spacedata[j][0];
                    copy[j][1] = -999;
                    copy[j][2] = -999;

                    spacedata[j][3]=projectdata[i][3];
                    break;
                }
                if(j+1==copy.length&&(this.projectdata[i][1] > copy[j][1] || this.projectdata[i][2] > copy[j][2])){
                    projectdata[i][4]=1;
                }

            }

        }


        return projectdata;
    }
    public String checkSameType(){
        List list1 = Arrays.asList(spacedata);

        sameType=false;
        for(int i =0;i<spacedata.length;i++){
            if(i==spacedata.length-1){
                break;
            }
            if(spacedata[i][3]==spacedata[i+1][3]){
                sameType=true;
            }
        }
        /*
        for(int i=0;i<projectdata.length;i++){
            if(i+1==projectdata.length){
                break;
            }
            if(Math.abs(projectdata[i][0]-projectdata[i+1][0])==1&&projectdata[i][3]==projectdata[i+1][3]){
                sameType=true;
                break;
            }
        }

         */
        if(sameType){
            return "There are projects belongs to same type placed sided by sided";
        }
        else{
            return"No same type project placed side by side";
        }

    }



    public int[][] getProjectdata() {
        return projectdata;
    }

    public int[][] getSpacedata() {

        return spacedata;
    }
    public int[][] getAllocation(){
        int [][]output=new int[projectdata.length][3];
        this.projectdata=getSortedproject();
        this.projectdata=allocateSize();
        for(int i=0;i<projectdata.length;i++){
            output[i][0]=projectdata[i][0];
            output[i][1]=projectdata[i][5];
            output[i][2]=projectdata[i][4];
        }

        return output;
    }



}
