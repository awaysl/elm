package com.hanma.elm.entity.other;

import eleme.openapi.sdk.api.entity.product.*;
import eleme.openapi.sdk.api.enumeration.product.ItemType;

import java.util.List;

public class OItemRequestChild {
    /**
     * 商品描述
     */
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 商品Id
     */
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * 商品名
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 是否有效
     */
    private int isValid;

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    /**
     * 最近一个月的售出份数
     */
    private int recentPopularity;

    public int getRecentPopularity() {
        return recentPopularity;
    }

    public void setRecentPopularity(int recentPopularity) {
        this.recentPopularity = recentPopularity;
    }

    /**
     * 商品分类Id
     */
    private long categoryId;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 店铺Id
     */
    private long shopId;

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    /**
     * 店铺名称
     */
    private String shopName;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * 商品主图片
     */
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 标签
     */
    private OLabel labels;

    public OLabel getLabels() {
        return labels;
    }

    public void setLabels(OLabel labels) {
        this.labels = labels;
    }

    /**
     * 规格的列表
     */
    private List<OSpec> specs;

    public List<OSpec> getSpecs() {
        return specs;
    }

    public void setSpecs(List<OSpec> specs) {
        this.specs = specs;
    }

    /**
     * 售卖时间
     */
    private OItemSellingTime sellingTime;

    public OItemSellingTime getSellingTime() {
        return sellingTime;
    }

    public void setSellingTime(OItemSellingTime sellingTime) {
        this.sellingTime = sellingTime;
    }

    /**
     * 属性
     */
    private List<OItemAttribute> attributes;

    public List<OItemAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<OItemAttribute> attributes) {
        this.attributes = attributes;
    }

    /**
     * 后台类目ID
     */
    private long backCategoryId;

    public long getBackCategoryId() {
        return backCategoryId;
    }

    public void setBackCategoryId(long backCategoryId) {
        this.backCategoryId = backCategoryId;
    }

    /**
     * 商品最小购买量
     */
    private int minPurchaseQuantity;

    public int getMinPurchaseQuantity() {
        return minPurchaseQuantity;
    }

    public void setMinPurchaseQuantity(int minPurchaseQuantity) {
        this.minPurchaseQuantity = minPurchaseQuantity;
    }

    /**
     * 商品单位
     */
    private String unit;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 商品套餐标签
     */
    private Integer setMeal;

    public Integer getSetMeal() {
        return setMeal;
    }

    public void setSetMeal(Integer setMeal) {
        this.setMeal = setMeal;
    }

    /**
     * 原材料
     */
    private List<OMaterial> materials;

    public List<OMaterial> getMaterials() {
        return materials;
    }

    public void setMaterials(List<OMaterial> materials) {
        this.materials = materials;
    }

    /**
     * 主图联动方式
     */
    private int imageLinkageType;

    public int getImageLinkageType() {
        return imageLinkageType;
    }

    public void setImageLinkageType(int imageLinkageType) {
        this.imageLinkageType = imageLinkageType;
    }

    /**
     * 商品副图片集合
     */
    private List<String> imageUrls;

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    /**
     * 商品视频信息
     */
    private OVideo video;

    public OVideo getVideo() {
        return video;
    }

    public void setVideo(OVideo video) {
        this.video = video;
    }

    /**
     * 商品类型
     */
    private ItemType itemType;

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    /**
     * 商品配料列表
     */
    private List<Long> subItemIds;

    public List<Long> getSubItemIds() {
        return subItemIds;
    }

    public void setSubItemIds(List<Long> subItemIds) {
        this.subItemIds = subItemIds;
    }

    /**
     * 商品套餐信息
     */
    private List<OPackageGroup> oPackages;

    public List<OPackageGroup> getOPackages() {
        return oPackages;
    }

    public void setOPackages(List<OPackageGroup> oPackages) {
        this.oPackages = oPackages;
    }

    /**
     * 商品配料组
     */
    private IngredientGroup ingredientGroup;

    public IngredientGroup getIngredientGroup() {
        return ingredientGroup;
    }

    public void setIngredientGroup(IngredientGroup ingredientGroup) {
        this.ingredientGroup = ingredientGroup;
    }

    /**
     * 是否上架，默认上架
     */
    private int onShelf;

    public int getOnShelf() {
        return onShelf;
    }

    public void setOnShelf(int onShelf) {
        this.onShelf = onShelf;
    }

    /**
     * 商品规格信息
     */
    private List<OSpecProperty> specProperties;

    public List<OSpecProperty> getSpecProperties() {
        return specProperties;
    }

    public void setSpecProperties(List<OSpecProperty> specProperties) {
        this.specProperties = specProperties;
    }

    /**
     * 配料组
     */
    private List<OIngredientGroupRelation> groupRelations;

    public List<OIngredientGroupRelation> getGroupRelations() {
        return groupRelations;
    }

    public void setGroupRelations(List<OIngredientGroupRelation> groupRelations) {
        this.groupRelations = groupRelations;
    }

    /**
     * 商品图片base64
     */
    private String imgBase64;

    public String getImgBase64() {
        return imgBase64;
    }

    public void setImgBase64(String imgBase64) {
        this.imgBase64 = imgBase64;
    }
}
