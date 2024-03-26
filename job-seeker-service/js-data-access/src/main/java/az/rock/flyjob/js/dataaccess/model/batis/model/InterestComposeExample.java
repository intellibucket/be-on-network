package az.rock.flyjob.js.dataaccess.model.batis.model;


import az.rock.flyjob.js.domain.core.exception.interest.InterestOverLimit;
import az.rock.flyjob.js.domain.presentation.dto.criteria.InterestCriteria;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.SimplePageableRequest;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@SuppressWarnings("all")
public class InterestComposeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Pageable pageable;


    public static class Pageable {
        private int offset;
        private int limit;

        private Pageable(int offset, int limit) {
            this.offset = offset;
            this.limit = limit;
        }

        public Pageable() {
        }

        private void setOffset(int offset) {
            this.offset = offset;
        }

        private void setLimit(int limit) {
            this.limit = limit;
        }

        public static Pageable createPageable(SimplePageableRequest request) throws InterestOverLimit {

            if (!(request.getSize() <= 0) && !(request.getPage() <= 0) ) {
                Pageable pageable = new Pageable();
                pageable.setLimit(request.getSize());
                pageable.setOffset((request.getPage() - 1) * pageable.limit);

                return pageable;

            } else {
                throw new InterestOverLimit();
            }
        }
    }


    public InterestComposeExample() {
        oredCriteria = new ArrayList<>();
    }

    public void addOrderConstraints(String orderByClause) {
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

    public Pageable getPageable() {
        return pageable;
    }

    public Pageable addPageable(Pageable pageable) {
        this.pageable = pageable;
        return this.pageable;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public static InterestComposeExample of(InterestCriteria interestCriteria) {
        InterestComposeExample example = new InterestComposeExample();
        example.addOrderConstraints("order_number");
        var criteria = example.createCriteria();
        criteria.andRowStatusEqualTo(RowStatus.ACTIVE.name());
        if (Optional.ofNullable(interestCriteria.getResume()).isPresent()) {
            criteria.andResumeUuidEqualTo(interestCriteria.getResume().getAbsoluteID());

        }

        if (Optional.ofNullable(interestCriteria.getId()).isPresent()) {
            criteria.andUuidEqualTo(interestCriteria.getId());

        }
        Optional<List<AccessModifier>> accessModifiersOptional = Optional.ofNullable(interestCriteria.getAccessModifier());
        if (accessModifiersOptional.isPresent()) {
            final AccessModifier accessModifier = accessModifiersOptional.get().stream()
                    .findAny().get();
            criteria.andAccessModifierEqualTo(accessModifier.name());

        }
        return example;

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

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(Object value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(Object value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(Object value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(Object value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(Object value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(Object value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<Object> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<Object> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(Object value1, Object value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(Object value1, Object value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIsNull() {
            addCriterion("process_status is null");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIsNotNull() {
            addCriterion("process_status is not null");
            return (Criteria) this;
        }

        public Criteria andProcessStatusEqualTo(String value) {
            addCriterion("process_status =", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotEqualTo(String value) {
            addCriterion("process_status <>", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusGreaterThan(String value) {
            addCriterion("process_status >", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusGreaterThanOrEqualTo(String value) {
            addCriterion("process_status >=", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLessThan(String value) {
            addCriterion("process_status <", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLessThanOrEqualTo(String value) {
            addCriterion("process_status <=", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusLike(String value) {
            addCriterion("process_status like", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotLike(String value) {
            addCriterion("process_status not like", value, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusIn(List<String> values) {
            addCriterion("process_status in", values, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotIn(List<String> values) {
            addCriterion("process_status not in", values, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusBetween(String value1, String value2) {
            addCriterion("process_status between", value1, value2, "processStatus");
            return (Criteria) this;
        }

        public Criteria andProcessStatusNotBetween(String value1, String value2) {
            addCriterion("process_status not between", value1, value2, "processStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusIsNull() {
            addCriterion("row_status is null");
            return (Criteria) this;
        }

        public Criteria andRowStatusIsNotNull() {
            addCriterion("row_status is not null");
            return (Criteria) this;
        }

        public Criteria andRowStatusEqualTo(String value) {
            addCriterion("row_status =", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusNotEqualTo(String value) {
            addCriterion("row_status <>", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusGreaterThan(String value) {
            addCriterion("row_status >", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusGreaterThanOrEqualTo(String value) {
            addCriterion("row_status >=", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusLessThan(String value) {
            addCriterion("row_status <", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusLessThanOrEqualTo(String value) {
            addCriterion("row_status <=", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusLike(String value) {
            addCriterion("row_status like", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusNotLike(String value) {
            addCriterion("row_status not like", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusIn(List<String> values) {
            addCriterion("row_status in", values, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusNotIn(List<String> values) {
            addCriterion("row_status not in", values, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusBetween(String value1, String value2) {
            addCriterion("row_status between", value1, value2, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusNotBetween(String value1, String value2) {
            addCriterion("row_status not between", value1, value2, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNull() {
            addCriterion("created_date is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNotNull() {
            addCriterion("created_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateEqualTo(Date value) {
            addCriterion("created_date =", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotEqualTo(Date value) {
            addCriterion("created_date <>", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThan(Date value) {
            addCriterion("created_date >", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("created_date >=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThan(Date value) {
            addCriterion("created_date <", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThanOrEqualTo(Date value) {
            addCriterion("created_date <=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIn(List<Date> values) {
            addCriterion("created_date in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotIn(List<Date> values) {
            addCriterion("created_date not in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateBetween(Date value1, Date value2) {
            addCriterion("created_date between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotBetween(Date value1, Date value2) {
            addCriterion("created_date not between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateIsNull() {
            addCriterion("modification_date is null");
            return (Criteria) this;
        }

        public Criteria andModificationDateIsNotNull() {
            addCriterion("modification_date is not null");
            return (Criteria) this;
        }

        public Criteria andModificationDateEqualTo(Date value) {
            addCriterion("modification_date =", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateNotEqualTo(Date value) {
            addCriterion("modification_date <>", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateGreaterThan(Date value) {
            addCriterion("modification_date >", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("modification_date >=", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateLessThan(Date value) {
            addCriterion("modification_date <", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateLessThanOrEqualTo(Date value) {
            addCriterion("modification_date <=", value, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateIn(List<Date> values) {
            addCriterion("modification_date in", values, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateNotIn(List<Date> values) {
            addCriterion("modification_date not in", values, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateBetween(Date value1, Date value2) {
            addCriterion("modification_date between", value1, value2, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andModificationDateNotBetween(Date value1, Date value2) {
            addCriterion("modification_date not between", value1, value2, "modificationDate");
            return (Criteria) this;
        }

        public Criteria andResumeUuidIsNull() {
            addCriterion("resume_uuid is null");
            return (Criteria) this;
        }

        public Criteria andResumeUuidIsNotNull() {
            addCriterion("resume_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andResumeUuidEqualTo(Object value) {
            addCriterion("resume_uuid =", value, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andResumeUuidNotEqualTo(Object value) {
            addCriterion("resume_uuid <>", value, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andResumeUuidGreaterThan(Object value) {
            addCriterion("resume_uuid >", value, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andResumeUuidGreaterThanOrEqualTo(Object value) {
            addCriterion("resume_uuid >=", value, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andResumeUuidLessThan(Object value) {
            addCriterion("resume_uuid <", value, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andResumeUuidLessThanOrEqualTo(Object value) {
            addCriterion("resume_uuid <=", value, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andResumeUuidIn(List<Object> values) {
            addCriterion("resume_uuid in", values, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andResumeUuidNotIn(List<Object> values) {
            addCriterion("resume_uuid not in", values, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andResumeUuidBetween(Object value1, Object value2) {
            addCriterion("resume_uuid between", value1, value2, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andResumeUuidNotBetween(Object value1, Object value2) {
            addCriterion("resume_uuid not between", value1, value2, "resumeUuid");
            return (Criteria) this;
        }

        public Criteria andAccessModifierIsNull() {
            addCriterion("access_modifier is null");
            return (Criteria) this;
        }

        public Criteria andAccessModifierIsNotNull() {
            addCriterion("access_modifier is not null");
            return (Criteria) this;
        }

        public Criteria andAccessModifierEqualTo(String value) {
            addCriterion("access_modifier =", value, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierNotEqualTo(String value) {
            addCriterion("access_modifier <>", value, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierGreaterThan(String value) {
            addCriterion("access_modifier >", value, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierGreaterThanOrEqualTo(String value) {
            addCriterion("access_modifier >=", value, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierLessThan(String value) {
            addCriterion("access_modifier <", value, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierLessThanOrEqualTo(String value) {
            addCriterion("access_modifier <=", value, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierLike(String value) {
            addCriterion("access_modifier like", value, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierNotLike(String value) {
            addCriterion("access_modifier not like", value, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierIn(List<String> values) {
            addCriterion("access_modifier in", values, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierNotIn(List<String> values) {
            addCriterion("access_modifier not in", values, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierBetween(String value1, String value2) {
            addCriterion("access_modifier between", value1, value2, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andAccessModifierNotBetween(String value1, String value2) {
            addCriterion("access_modifier not between", value1, value2, "accessModifier");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(Integer value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(Integer value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(Integer value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(Integer value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(Integer value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<Integer> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<Integer> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(Integer value1, Integer value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andIsHobbyIsNull() {
            addCriterion("is_hobby is null");
            return (Criteria) this;
        }

        public Criteria andIsHobbyIsNotNull() {
            addCriterion("is_hobby is not null");
            return (Criteria) this;
        }

        public Criteria andIsHobbyEqualTo(Boolean value) {
            addCriterion("is_hobby =", value, "isHobby");
            return (Criteria) this;
        }

        public Criteria andIsHobbyNotEqualTo(Boolean value) {
            addCriterion("is_hobby <>", value, "isHobby");
            return (Criteria) this;
        }

        public Criteria andIsHobbyGreaterThan(Boolean value) {
            addCriterion("is_hobby >", value, "isHobby");
            return (Criteria) this;
        }

        public Criteria andIsHobbyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_hobby >=", value, "isHobby");
            return (Criteria) this;
        }

        public Criteria andIsHobbyLessThan(Boolean value) {
            addCriterion("is_hobby <", value, "isHobby");
            return (Criteria) this;
        }

        public Criteria andIsHobbyLessThanOrEqualTo(Boolean value) {
            addCriterion("is_hobby <=", value, "isHobby");
            return (Criteria) this;
        }

        public Criteria andIsHobbyIn(List<Boolean> values) {
            addCriterion("is_hobby in", values, "isHobby");
            return (Criteria) this;
        }

        public Criteria andIsHobbyNotIn(List<Boolean> values) {
            addCriterion("is_hobby not in", values, "isHobby");
            return (Criteria) this;
        }

        public Criteria andIsHobbyBetween(Boolean value1, Boolean value2) {
            addCriterion("is_hobby between", value1, value2, "isHobby");
            return (Criteria) this;
        }

        public Criteria andIsHobbyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_hobby not between", value1, value2, "isHobby");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
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
