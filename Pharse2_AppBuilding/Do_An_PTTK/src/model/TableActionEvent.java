package model;

public interface TableActionEvent {
    
    public void onEdit(int row);
    public void onDelete(int row);
    public void onNote(int row);   
}
