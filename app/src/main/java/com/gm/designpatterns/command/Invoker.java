package com.gm.designpatterns.command;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/12 13:24
 * Description: Invoker
 * Company : 北京四维图新科技股份有限公司
 */
public class Invoker {
    Command command;
    public void setCommand(Command command){
        this.command=command;
    }
    public void buttonPressed(){
        command.execute();
    }
}
