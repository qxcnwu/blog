package com.qxc.blog.pojo;

import java.util.ArrayList;
import java.util.List;

public class BlogRelationshipExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogRelationshipExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdxIsNull() {
            addCriterion("idx is null");
            return (Criteria) this;
        }

        public Criteria andIdxIsNotNull() {
            addCriterion("idx is not null");
            return (Criteria) this;
        }

        public Criteria andIdxEqualTo(Integer value) {
            addCriterion("idx =", value, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxNotEqualTo(Integer value) {
            addCriterion("idx <>", value, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxGreaterThan(Integer value) {
            addCriterion("idx >", value, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxGreaterThanOrEqualTo(Integer value) {
            addCriterion("idx >=", value, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxLessThan(Integer value) {
            addCriterion("idx <", value, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxLessThanOrEqualTo(Integer value) {
            addCriterion("idx <=", value, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxIn(List<Integer> values) {
            addCriterion("idx in", values, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxNotIn(List<Integer> values) {
            addCriterion("idx not in", values, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxBetween(Integer value1, Integer value2) {
            addCriterion("idx between", value1, value2, "idx");
            return (Criteria) this;
        }

        public Criteria andIdxNotBetween(Integer value1, Integer value2) {
            addCriterion("idx not between", value1, value2, "idx");
            return (Criteria) this;
        }

        public Criteria andFatheridxIsNull() {
            addCriterion("fatherIdx is null");
            return (Criteria) this;
        }

        public Criteria andFatheridxIsNotNull() {
            addCriterion("fatherIdx is not null");
            return (Criteria) this;
        }

        public Criteria andFatheridxEqualTo(String value) {
            addCriterion("fatherIdx =", value, "fatheridx");
            return (Criteria) this;
        }

        public Criteria andFatheridxNotEqualTo(String value) {
            addCriterion("fatherIdx <>", value, "fatheridx");
            return (Criteria) this;
        }

        public Criteria andFatheridxGreaterThan(String value) {
            addCriterion("fatherIdx >", value, "fatheridx");
            return (Criteria) this;
        }

        public Criteria andFatheridxGreaterThanOrEqualTo(String value) {
            addCriterion("fatherIdx >=", value, "fatheridx");
            return (Criteria) this;
        }

        public Criteria andFatheridxLessThan(String value) {
            addCriterion("fatherIdx <", value, "fatheridx");
            return (Criteria) this;
        }

        public Criteria andFatheridxLessThanOrEqualTo(String value) {
            addCriterion("fatherIdx <=", value, "fatheridx");
            return (Criteria) this;
        }

        public Criteria andFatheridxLike(String value) {
            addCriterion("fatherIdx like", value, "fatheridx");
            return (Criteria) this;
        }

        public Criteria andFatheridxNotLike(String value) {
            addCriterion("fatherIdx not like", value, "fatheridx");
            return (Criteria) this;
        }

        public Criteria andFatheridxIn(List<String> values) {
            addCriterion("fatherIdx in", values, "fatheridx");
            return (Criteria) this;
        }

        public Criteria andFatheridxNotIn(List<String> values) {
            addCriterion("fatherIdx not in", values, "fatheridx");
            return (Criteria) this;
        }

        public Criteria andFatheridxBetween(String value1, String value2) {
            addCriterion("fatherIdx between", value1, value2, "fatheridx");
            return (Criteria) this;
        }

        public Criteria andFatheridxNotBetween(String value1, String value2) {
            addCriterion("fatherIdx not between", value1, value2, "fatheridx");
            return (Criteria) this;
        }

        public Criteria andSonidxIsNull() {
            addCriterion("sonIdx is null");
            return (Criteria) this;
        }

        public Criteria andSonidxIsNotNull() {
            addCriterion("sonIdx is not null");
            return (Criteria) this;
        }

        public Criteria andSonidxEqualTo(String value) {
            addCriterion("sonIdx =", value, "sonidx");
            return (Criteria) this;
        }

        public Criteria andSonidxNotEqualTo(String value) {
            addCriterion("sonIdx <>", value, "sonidx");
            return (Criteria) this;
        }

        public Criteria andSonidxGreaterThan(String value) {
            addCriterion("sonIdx >", value, "sonidx");
            return (Criteria) this;
        }

        public Criteria andSonidxGreaterThanOrEqualTo(String value) {
            addCriterion("sonIdx >=", value, "sonidx");
            return (Criteria) this;
        }

        public Criteria andSonidxLessThan(String value) {
            addCriterion("sonIdx <", value, "sonidx");
            return (Criteria) this;
        }

        public Criteria andSonidxLessThanOrEqualTo(String value) {
            addCriterion("sonIdx <=", value, "sonidx");
            return (Criteria) this;
        }

        public Criteria andSonidxLike(String value) {
            addCriterion("sonIdx like", value, "sonidx");
            return (Criteria) this;
        }

        public Criteria andSonidxNotLike(String value) {
            addCriterion("sonIdx not like", value, "sonidx");
            return (Criteria) this;
        }

        public Criteria andSonidxIn(List<String> values) {
            addCriterion("sonIdx in", values, "sonidx");
            return (Criteria) this;
        }

        public Criteria andSonidxNotIn(List<String> values) {
            addCriterion("sonIdx not in", values, "sonidx");
            return (Criteria) this;
        }

        public Criteria andSonidxBetween(String value1, String value2) {
            addCriterion("sonIdx between", value1, value2, "sonidx");
            return (Criteria) this;
        }

        public Criteria andSonidxNotBetween(String value1, String value2) {
            addCriterion("sonIdx not between", value1, value2, "sonidx");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}