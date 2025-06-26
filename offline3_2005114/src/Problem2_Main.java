import FileSystem.*;

import java.util.Scanner;

public class Problem2_Main {
    public static void main(String[] args) {
        FileSystem f=null,curr=null;
        Scanner scan = new Scanner(System.in);
        String []cmd=scan.nextLine().split(" ");
        while(!cmd[0].equals("mkdrive")){
            System.out.println("Please first create a drive.");
            cmd=scan.nextLine().split(" ");
        }
        while (true){

            if(cmd[0].equals("mkdrive")){
                f = new Drive(cmd[1],"");
                curr=null;
            } else if (cmd[0].equals("cd")) {
                String[] drct=cmd[1].split("\\\\");
//                System.out.println("inside cd");
//                for (String t:drct) {
//                    System.out.println("\t\tInside cd :"+t);
//                }
                if(drct.length==1){
                    if(f!=null){
                        //System.out.println("f not null");
                        curr=f;    
                    }else{
                        System.out.println("No drive exists.Please create a drive first.");
                    }
                } else if (cmd[1].equals("~")) {
                    curr=null;
                } else{
                    //System.out.println("hi");
                    curr=f.getDirectedFolder(drct[drct.length-1]);
                }
            } else if (cmd[0].equals("ls")) {
                if(cmd[1].equals(f.getName())){
                    f.getDetails();
                }else {
                    f.getDirectedFolder(cmd[1]).getDetails();
                }
            } else if (cmd[0].equals("list")) {
                if(curr!=null){
                    curr.listing();
                }
            } else if (cmd[0].equals("delete") && cmd.length==2) {
                int sz=curr.delete(cmd[1]);
                String[] drct=curr.getDirectory().split("\\\\");
                //System.out.println(curr.getDirectory());
                f.setSize(-sz);
                FileSystem tmp =f;
                //curr.setSize(Integer.parseInt(cmd[2]));
                for (int i = 1; i < drct.length; i++) {
                    //System.out.println("vitre");
                    tmp=tmp.getDirectedFolder(drct[i]);
                    System.out.println(tmp.getName());
                    if(tmp==null){
                        //System.out.println("null");
                        break;

                    }
                    tmp.setSize(-sz);

                }
            } else if (cmd[0].equals("delete") && cmd.length==3 && cmd[1]=="-r") {
                int sz=curr.recursiveDelete(cmd[2]);

                String[] drct=curr.getDirectory().split("\\\\");
                //System.out.println(curr.getDirectory());
                f.setSize(-sz);
                FileSystem tmp =f;
                //curr.setSize(Integer.parseInt(cmd[2]));
                for (int i = 1; i < drct.length; i++) {

                    tmp=tmp.getDirectedFolder(drct[i]);
                    System.out.println(tmp.getName());
                    if(tmp==null){
                        //System.out.println("null");
                        break;

                    }
                    tmp.setSize(-sz);

                }
            } else if (cmd[0].equals("mkdir")) {
                curr.createFolder(cmd[1]);
            } else if (cmd[0].equals("touch")) {
                curr.createFile(cmd[1],Integer.parseInt(cmd[2]));
                String[] drct=curr.getDirectory().split("\\\\");
//                for (String t:drct) {
//                    System.out.println("\t\t Inside drct:"+t);
//                }
//                System.out.println(curr.getDirectory());
                f.setSize(Integer.parseInt(cmd[2]));
                FileSystem tmp =f;
                curr.setSize(Integer.parseInt(cmd[2]));
                for (int i = 1; i < drct.length; i++) {
                    //System.out.println("vitre");
                    tmp=tmp.getDirectedFolder(drct[i]);
                    System.out.println(tmp.getName());
                    if(tmp==null){
                       // System.out.println("null");
                        break;

                    }
                    tmp.setSize(Integer.parseInt(cmd[2]));

                }
            } else if(cmd[0].equals("exit")){
                break;
            }

            cmd=scan.nextLine().split(" ");
        }
    }
}
