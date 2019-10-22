package com.gm.designpatterns.command;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/12 13:20
 * Description: LightOnCommand
 * Company : 北京四维图新科技股份有限公司
 */
public class LightOnCommand  implements Command {

   Light light;

    public LightOnCommand(Light light){
        this.light=light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
