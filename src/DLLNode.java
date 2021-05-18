//----------------------------------------------------------------------------
// DLLNode.java              by Dale/Joyce/Weems                     Chapter 4
//
// Implements nodes holding info of class <T> for a doubly linked list.
// V. Gehlot: fixed return type of getForward and getBack from DLLNode (raw Type)
// to DLLNode<T> for better type safety.
//----------------------------------------------------------------------------



public class DLLNode<T> 
{
  private T info;
  private DLLNode<T> forward, back;
  
  public DLLNode(T info)
  {
    this.info = info; forward = null; back = null;
  }
 
  public void setInfo(T info){this.info = info;}
  public T getInfo(){return info;}
  
  public void setForward(DLLNode<T> forward){this.forward = forward;}
  public void setBack(DLLNode<T> back){this.back = back;}
  
  public DLLNode<T> getForward(){return forward;}
  public DLLNode<T> getBack(){return back;}
}
 
 