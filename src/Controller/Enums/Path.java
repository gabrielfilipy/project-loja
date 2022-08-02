
package Controller.Enums;

public enum Path {
    
    PATH_IMAGE ("C:\\projects\\files\\image\\");

    private String path;
    
    private Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

}
