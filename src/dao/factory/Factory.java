package dao.factory;

import dao.proxy.*;

public class Factory {
    public static StepDAOImpllProxy getStepDAOImplProxy(){
        return new StepDAOImpllProxy();
    }

    public static PlanDAOImpllProxy getPlanDAOImplProxy(){
        return new PlanDAOImpllProxy();
    }

    public static TextDAOImpllProxy getTextDAOImplProxy(){
        return new TextDAOImpllProxy();
    }

    public static EatDAOImpllProxy getFoodDAOImplProxy(){
        return new EatDAOImpllProxy();
    }

    public static UFoodDAOImpllProxy getUFoodDAOImplProxy(){
        return new UFoodDAOImpllProxy();
    }

    public static UserInfoDAOImplProxy getUserInfoDAOImplProxy(){
        return new UserInfoDAOImplProxy();
    }
    public static MallDAOImplProxy getMallDAOImplProxy(){
        return new MallDAOImplProxy();
    }
    public static BannerDAOImpllProxy getBannerDAOImpllProxy(){
        return new BannerDAOImpllProxy();
    }
    public static SearchDAOImplProxy getSearchDAOImplProxy()
    {
        return new SearchDAOImplProxy();
}}
