package com.example.demo.util;

import java.io.Serializable;

public class PageQueryModel implements Serializable {

    private Integer pageNum;

    private Integer pageSize = 20;

    private String orderBy;

    private String conditionJson;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getPageNum() {
        if(pageNum == null || pageNum ==0){
            pageNum = 1;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if(pageSize == null || pageSize ==0){
            pageSize=20;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getConditionJson() {
        return conditionJson;
    }

    public void setConditionJson(String conditionJson) {
        this.conditionJson = conditionJson;
    }

    public class ConditionModel{

        private String property;

        private String condition;

        private String value1;

        private String value2;

        private OperatorEnum operator;


        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public String getValue1() {
            return value1;
        }

        public void setValue1(String value1) {
            this.value1 = value1;
        }

        public String getValue2() {
            return value2;
        }

        public void setValue2(String value2) {
            this.value2 = value2;
        }

        public OperatorEnum getOperator() {
            return operator;
        }

        public void setOperator(OperatorEnum operator) {
            this.operator = operator;
        }

        public String getConditionMethodName(){
            StringBuffer conditionMethodName = new StringBuffer();
            conditionMethodName.append("and");
            conditionMethodName.append(this.getProperty());
            conditionMethodName.append(this.getCondition());
            return conditionMethodName.toString();
        }
    }
}
