import common.CommonUtil;
import dao.MoneyDetailDao;
import domain.MoneyDetail;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import pages.MoneyDetailPage;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 * Main
 * create by chenshihang on 2018/6/20
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {



        try
        {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
            UIManager.put("RootPane.setupButtonVisible", false);
            BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }
        catch(Exception e) {
            System.out.println("beautyEey未使用");
        }






        MoneyDetailPage moneyDetailPage = new MoneyDetailPage();
        MoneyDetailDao moneyDetailDao = new MoneyDetailDao();
        List<MoneyDetail> moneyDetailList = moneyDetailDao.getAllMoneyDetail();

        Vector<Vector<String>> tabledatas = CommonUtil.listToVector(moneyDetailList);
        Vector<String> tableHeads = CommonUtil.initTableHead();
        moneyDetailPage.init(tableHeads,tabledatas);
    }
}
