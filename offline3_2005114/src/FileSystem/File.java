package FileSystem;

import java.text.SimpleDateFormat;
import java.util.Date;

public class File implements FileSystem{
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
        this.size=size;
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

    @Override
    public void listing() {

    }

    @Override
    public void createFolder(String name) {

    }

    @Override
    public void createFile(String name, int size) {

    }

    @Override
    public int delete(String name) {
        return 0;
    }

    @Override
    public int recursiveDelete(String name) {
        return 0;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public Folder getDirectedFolder(String name) {
        return null;
    }

    public File(String name, String directory,int size){
        this.name=name;
        this.directory=directory;
        this.size=size;
        this.comp_count=0;
        this.type="File";
        this.creation_time=new Date();
    }
}
