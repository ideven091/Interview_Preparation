package com.cleo.assessment;

public class PatternMatching {


    static char MULTI_MATCHER='*',SINGLE_MATCHER='?';
    public static boolean globMatching(String fileName, String pattern) {
        // Write your code here.
        boolean flag = true;
        int i=0,j=0;


        while( i<fileName.length()&&j<pattern.length()){
            System.out.println(j);
            if(pattern.charAt(j)==fileName.charAt(i)) {
                j++;i++;
            }
            else if(pattern.charAt(j)==MULTI_MATCHER) {



                if (j +1< pattern.length()) {

                    j+=1;
                    if(j==pattern.length())
                        return true;



                }
                System.out.println("j"+j);







                while(pattern.charAt(j)!=fileName.charAt(i)){
                    i++;
                }
                if(i==fileName.length()-1)
                    return true;
            }else if(pattern.charAt(j)==SINGLE_MATCHER){
                i++;j++;
            }



        }
        return i==fileName.length()&&j==pattern.length();
    }

    public static void main(String[] args) {
        String pattern ="*";
        String fileName = "abcdefg";
        System.out.println(globMatching(fileName,pattern));
    }
}
