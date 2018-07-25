package common;

import domain.MoneyDetail;
import domain.Student;

import java.util.List;
import java.util.Vector;

/**
 * CommonUtil
 * create by chenshihang on 2018/6/20
 */
public class CommonUtil {


    public static Vector<Vector<String>> listToVector(List<MoneyDetail> moneyDetails){

        Vector<Vector<String>> result  = new Vector<>();

        for(MoneyDetail item: moneyDetails){
            Vector<String> stringVector = new Vector<>();
            stringVector.add(item.getIncome()+"");
            stringVector.add(item.getOutcome()+"");
            stringVector.add(item.getDetail()+"");
            stringVector.add(item.getRestMoney()+"");
            stringVector.add(item.getDescription());
            stringVector.add(item.getStuName());
            stringVector.add(item.getStuId()+"");
            stringVector.add(item.getNotes());
            stringVector.add(item.getRecordBy());
            stringVector.add(item.getCreateTime()+"");
            result.add(stringVector);
        }
        return result;
    }

    public static Vector<String> initTableHead(){
        Vector<String> result = new Vector<>();
        result.add("收入");
        result.add("支出");
        result.add("明细");
        result.add("当前余额");
        result.add("描述");
        result.add("姓名");
        result.add("学号");
        result.add("备注");
        result.add("记录人");
        result.add("时间");
        return result;
    }
}
