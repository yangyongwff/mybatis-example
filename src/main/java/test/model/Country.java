package test.model;

import tk.mybatis.simple.model.BaseEntity;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table country
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class Country extends BaseEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column country.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column country.countryname
     *
     * @mbggenerated
     */
    private String countryname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column country.countrycode
     *
     * @mbggenerated
     */
    private String countrycode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column country.id
     *
     * @return the value of country.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column country.id
     *
     * @param id the value for country.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column country.countryname
     *
     * @return the value of country.countryname
     *
     * @mbggenerated
     */
    public String getCountryname() {
        return countryname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column country.countryname
     *
     * @param countryname the value for country.countryname
     *
     * @mbggenerated
     */
    public void setCountryname(String countryname) {
        this.countryname = countryname == null ? null : countryname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column country.countrycode
     *
     * @return the value of country.countrycode
     *
     * @mbggenerated
     */
    public String getCountrycode() {
        return countrycode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column country.countrycode
     *
     * @param countrycode the value for country.countrycode
     *
     * @mbggenerated
     */
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode == null ? null : countrycode.trim();
    }
}