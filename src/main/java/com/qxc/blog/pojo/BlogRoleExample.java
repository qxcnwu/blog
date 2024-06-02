package com.qxc.blog.pojo;

import java.util.ArrayList;
import java.util.List;

public class BlogRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogRoleExample() {
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

        public Criteria andIndexIsNull() {
            addCriterion("index is null");
            return (Criteria) this;
        }

        public Criteria andIndexIsNotNull() {
            addCriterion("index is not null");
            return (Criteria) this;
        }

        public Criteria andIndexEqualTo(Long value) {
            addCriterion("index =", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotEqualTo(Long value) {
            addCriterion("index <>", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexGreaterThan(Long value) {
            addCriterion("index >", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("index >=", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexLessThan(Long value) {
            addCriterion("index <", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexLessThanOrEqualTo(Long value) {
            addCriterion("index <=", value, "index");
            return (Criteria) this;
        }

        public Criteria andIndexIn(List<Long> values) {
            addCriterion("index in", values, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotIn(List<Long> values) {
            addCriterion("index not in", values, "index");
            return (Criteria) this;
        }

        public Criteria andIndexBetween(Long value1, Long value2) {
            addCriterion("index between", value1, value2, "index");
            return (Criteria) this;
        }

        public Criteria andIndexNotBetween(Long value1, Long value2) {
            addCriterion("index not between", value1, value2, "index");
            return (Criteria) this;
        }

        public Criteria andArticleidIsNull() {
            addCriterion("articleid is null");
            return (Criteria) this;
        }

        public Criteria andArticleidIsNotNull() {
            addCriterion("articleid is not null");
            return (Criteria) this;
        }

        public Criteria andArticleidEqualTo(String value) {
            addCriterion("articleid =", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotEqualTo(String value) {
            addCriterion("articleid <>", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidGreaterThan(String value) {
            addCriterion("articleid >", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidGreaterThanOrEqualTo(String value) {
            addCriterion("articleid >=", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidLessThan(String value) {
            addCriterion("articleid <", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidLessThanOrEqualTo(String value) {
            addCriterion("articleid <=", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidLike(String value) {
            addCriterion("articleid like", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotLike(String value) {
            addCriterion("articleid not like", value, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidIn(List<String> values) {
            addCriterion("articleid in", values, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotIn(List<String> values) {
            addCriterion("articleid not in", values, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidBetween(String value1, String value2) {
            addCriterion("articleid between", value1, value2, "articleid");
            return (Criteria) this;
        }

        public Criteria andArticleidNotBetween(String value1, String value2) {
            addCriterion("articleid not between", value1, value2, "articleid");
            return (Criteria) this;
        }

        public Criteria andAllowedusernameIsNull() {
            addCriterion("allowedusername is null");
            return (Criteria) this;
        }

        public Criteria andAllowedusernameIsNotNull() {
            addCriterion("allowedusername is not null");
            return (Criteria) this;
        }

        public Criteria andAllowedusernameEqualTo(String value) {
            addCriterion("allowedusername =", value, "allowedusername");
            return (Criteria) this;
        }

        public Criteria andAllowedusernameNotEqualTo(String value) {
            addCriterion("allowedusername <>", value, "allowedusername");
            return (Criteria) this;
        }

        public Criteria andAllowedusernameGreaterThan(String value) {
            addCriterion("allowedusername >", value, "allowedusername");
            return (Criteria) this;
        }

        public Criteria andAllowedusernameGreaterThanOrEqualTo(String value) {
            addCriterion("allowedusername >=", value, "allowedusername");
            return (Criteria) this;
        }

        public Criteria andAllowedusernameLessThan(String value) {
            addCriterion("allowedusername <", value, "allowedusername");
            return (Criteria) this;
        }

        public Criteria andAllowedusernameLessThanOrEqualTo(String value) {
            addCriterion("allowedusername <=", value, "allowedusername");
            return (Criteria) this;
        }

        public Criteria andAllowedusernameLike(String value) {
            addCriterion("allowedusername like", value, "allowedusername");
            return (Criteria) this;
        }

        public Criteria andAllowedusernameNotLike(String value) {
            addCriterion("allowedusername not like", value, "allowedusername");
            return (Criteria) this;
        }

        public Criteria andAllowedusernameIn(List<String> values) {
            addCriterion("allowedusername in", values, "allowedusername");
            return (Criteria) this;
        }

        public Criteria andAllowedusernameNotIn(List<String> values) {
            addCriterion("allowedusername not in", values, "allowedusername");
            return (Criteria) this;
        }

        public Criteria andAllowedusernameBetween(String value1, String value2) {
            addCriterion("allowedusername between", value1, value2, "allowedusername");
            return (Criteria) this;
        }

        public Criteria andAllowedusernameNotBetween(String value1, String value2) {
            addCriterion("allowedusername not between", value1, value2, "allowedusername");
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