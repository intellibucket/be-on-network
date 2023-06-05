package az.rock.lib.valueObject;

import java.util.Objects;

public enum PriorityValue{
     MAX(Integer.MAX_VALUE)
    ,NORMAL(0)
    ,MIN(Integer.MIN_VALUE)
    ,UNDEFINED(null);

    private Integer priority;
    PriorityValue(Integer priority) {
        this.priority  = priority;
    }

    public void increasePriority(){
        this.priority++;
    }

    public void decreasePriority(){
        this.priority--;
    }

    public Integer getPriority(){
        return this.priority;
    }

    public void setPriority(Integer priority){
        this.priority = priority;
    }

    public static PriorityValue valueOf(Integer priority){
        if(priority == null) return UNDEFINED;
        if(priority > 0) return MAX;
        else if(priority < 0) return MIN;
        else return NORMAL;
    }

    public Boolean after(PriorityValue priority){
        return this.priority > priority.getPriority();
    }

    public Boolean before(PriorityValue priority){
        return this.priority < priority.getPriority();
    }

    public Boolean equals(PriorityValue priority){
        return Objects.equals(this.priority, priority.getPriority());
    }

}
