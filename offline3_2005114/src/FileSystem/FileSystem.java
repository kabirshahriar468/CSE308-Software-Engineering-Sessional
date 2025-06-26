package FileSystem;



import java.util.Date;

public interface FileSystem {

    public void setName(String name);
    public void setSize(int size);
    public void setType(String type);
    public void setDirectory(String directory);
    public void setComp_count(int cnt);
    public void setCreation_time(Date date);
    public String getName();
    public String getType();
    public String getDirectory();
    public int getSize();
    public int getComp_count();
    public Date getCreation_time();
    public void getDetails();
    public void listing();
    public void createFolder(String name);
    public void createFile(String name, int size);
    public int delete(String name);
    public int recursiveDelete(String name);
    public boolean deleteAll();
    public Folder getDirectedFolder(String name);



}
