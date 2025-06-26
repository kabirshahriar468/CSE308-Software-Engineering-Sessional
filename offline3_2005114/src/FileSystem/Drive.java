package FileSystem;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Drive implements FileSystem{
    private String name ;
    private int size;
    private String type;
    private String directory;
    private int comp_count;
    private Date creation_time ;
    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void setSize(int size) {

        this.size+=size;

    }

    @Override
    public void setType(String type) {
        this.type=type;
    }

    @Override
    public void setDirectory(String directory) {
        this.directory=directory;
    }

    @Override
    public void setComp_count(int cnt) {
        this.comp_count=cnt;
    }

    @Override
    public void setCreation_time(Date date) {
        this.creation_time=date;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getDirectory() {
        return directory;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getComp_count() {
        return comp_count;
    }

    @Override
    public Date getCreation_time() {
        return creation_time;
    }

    @Override
    public void getDetails() {
        System.out.println("    Name : "+name);
        System.out.println("    Type : "+type);
        System.out.println("    Size : "+size);
        System.out.println("    Directory : \""+directory+"\"");
        System.out.println("    Component Count : "+comp_count);

        SimpleDateFormat formatter = new SimpleDateFormat("d MMMM, yyyy h:mm a");
        System.out.println("    Creation time : "+formatter.format(creation_time));

    }
    private List<Folder> subFolders;
    private List<File> subFiles;
    public Drive(String name,String directory ){
        this.name=name;
        this.directory=directory;
        this.size=this.comp_count=0;
        this.type="Drive";
        this.creation_time=new Date();
        subFolders=new ArrayList<Folder>();
        subFiles=new ArrayList<File>();
    }

    public void listing(){
        for (File f:subFiles) {
            System.out.println(f.getName()+"\t"+f.getSize()+" kB\t\t"+f.getCreation_time());
        }
        for (Folder f:subFolders) {
            System.out.println(f.getName()+"\t"+f.getSize()+" kB\t\t"+f.getCreation_time());
        }
    }
    public void createFolder(String name){
        Folder f=new Folder(name,this.name);
        subFolders.add(f);
        this.comp_count++;
    }
    public void createFile(String name, int size){
        this.comp_count++;
        subFiles.add(new File(name,this.name,size));
    }
    public int delete(String name){
        int size=0;
        for (File f:subFiles) {
            if(f.getName().equals(name)){
                this.size-=f.getSize();
                size=f.getSize();
                this.comp_count--;
                subFiles.remove(f);
                return size;
            }
        }
        for (Folder f:subFolders) {
            if(f.getName().equals(name) ){
                if( f.subFolders.isEmpty() && f.subFiles.isEmpty()) {
                   // this.size-=f.getSize();
                    this.comp_count--;
                    subFolders.remove(f);
                    return 0;
                }else{
                    System.out.println("Folder is not empty.");
                }
            }
        }
        return 0;
    }
    public int recursiveDelete(String name){
        int sz=0;
        for (File f:subFiles) {
            if(f.getName().equals(name)){
                this.size-=f.getSize();
                sz=f.getSize();
                this.comp_count--;
                subFiles.remove(f);
                System.out.println("You need not use recursive delete to delete a file.");
                return sz;
            }
        }
        for (Folder f:subFolders) {
            if(f.getName().equals(name) ){
                this.size-=f.getSize();
                sz=f.getSize();
                this.comp_count--;
                f.deleteAll();
                subFolders.remove(f);
                return sz;
            }
        }
        return 0;
    }
    public boolean deleteAll(){
        if(subFiles.isEmpty() && subFolders.isEmpty()){return true;}
        if(!subFiles.isEmpty()){
            subFiles.clear();
        }
        if(subFolders.isEmpty()){
            return true;
        }
        for (Folder f:subFolders) {
            f.deleteAll();
        }
        return true;
    }
    public Folder getDirectedFolder(String name){
        Folder ret=null;
        if(subFolders.isEmpty()){
            return null;
        }
        for (Folder f:subFolders) {
            if(f.getName().equals(name)){
                return f;
            }else{
                ret=f.getDirectedFolder(name);
                if(ret==null){
                    continue;
                }else{
                    return ret;
                }
            }
        }
        return null;
    }


}
