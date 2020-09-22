package com.eric.bottombarlibrary.view.tab;

/**
 * Created by gechuanguang on 2017/4/28.
 * 邮箱：1944633835@qq.com
 */
public class TabModel {

    private String tabText;

    private int tabNormalIcon;
    private int selectedIcon;

    private int normalTextcolor;
    private int selectedTextColor;


    public TabModel(Builder builder) {

        this.tabText = builder.tabText;
        this.tabNormalIcon = builder.tabNormalIcon;
        this.selectedIcon = builder.selectedIcon;
        this.normalTextcolor = builder.normalTextcolor;
        this.selectedTextColor = builder.selectedTextColor;

    }

    public void setNormalTextcolor(int normalTextcolor) {
        this.normalTextcolor = normalTextcolor;
    }

    public void setSelectedTextColor(int selectedTextColor) {
        this.selectedTextColor = selectedTextColor;
    }

    public String getTabText() {
        return tabText;
    }

    public int getSelectedTextColor() {
        return selectedTextColor;
    }

    public int getNormalTextcolor() {
        return normalTextcolor;
    }

    public int getTabNormalIcon() {
        return tabNormalIcon;
    }

    public int getSelectedIcon() {
        return selectedIcon;
    }

    public static class Builder {
        private String tabText;
        private int normalTextcolor;
        private int selectedTextColor;

        private int tabNormalIcon;
        private int selectedIcon;

        public Builder addTabText(String tabText) {
            this.tabText = tabText;
            return this;
        }

        public Builder addNormalTabTextColor(int normalTextcolor) {
            this.normalTextcolor = normalTextcolor;
            return this;
        }

        public Builder addSelectedTabTextColor(int selectedTextColor) {
            this.selectedTextColor = selectedTextColor;
            return this;
        }

        public Builder addTabNormalIcon(int tabNormalIcon) {
            this.tabNormalIcon = tabNormalIcon;
            return this;
        }

        public Builder addTabSelectedIcon(int selectedIcon) {
            this.selectedIcon = selectedIcon;
            return this;
        }

        public TabModel build() {
            return new TabModel(this);
        }

    }
}
