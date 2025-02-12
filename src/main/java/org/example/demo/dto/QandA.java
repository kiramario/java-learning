package org.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

public class QandA {
    private String Category;
    private String SubCategory;
    private String Difficulty;
    private String Title;
    private String ProblemDescription;
    private String SampleInput;
    private String SampleOutput;
    private String Hints;
    private String OptimalSpaceAndTimeComplexity;
    private String Solution;

    // 无参构造函数
    public QandA() { }

    public QandA(String category, String subCategory, String difficulty, String title, String ProblemDescription, String sampleInput, String sampleOutput, String hints, String optimalSpaceAndTimeComplexity, String solution) {
        this.Category = category;
        this.SubCategory = subCategory;
        this.Difficulty = difficulty;
        this.Title = title;
        this.ProblemDescription = ProblemDescription;
        this.SampleInput = sampleInput;
        this.SampleOutput = sampleOutput;
        this.Hints = hints;
        this.OptimalSpaceAndTimeComplexity = optimalSpaceAndTimeComplexity;
        this.Solution = solution;
    }

    public String getCategory() {
        return Category;
    }

    @JsonProperty("Category")
    public void setCategory(String category) {
        this.Category = category;
    }

    public String getSubCategory() {
        return SubCategory;
    }

    @JsonProperty("SubCategory")
    public void setSubCategory(String subCategory) {
        this.SubCategory = subCategory;
    }

    public String getDifficulty() {
        return Difficulty;
    }

    @JsonProperty("Difficulty")
    public void setDifficulty(String difficulty) {
        this.Difficulty = difficulty;
    }

    public String getTitle() {
        return Title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.Title = title;
    }

    public String getProblemDescription() {
        return ProblemDescription;
    }

    @JsonProperty("ProblemDescription")
    public void setProblemDescription(String ProblemDescription) {
        this.ProblemDescription = ProblemDescription;
    }

    public String getSampleInput() {
        return SampleInput;
    }

    @JsonProperty("SampleInput")
    public void setSampleInput(String sampleInput) {
        this.SampleInput = sampleInput;
    }

    public String getSampleOutput() {
        return SampleOutput;
    }

    @JsonProperty("SampleOutput")
    public void setSampleOutput(String sampleOutput) {
        this.SampleOutput = sampleOutput;
    }

    public String getHints() {
        return Hints;
    }

    @JsonProperty("Hints")
    public void setHints(String hints) {
        this.Hints = hints;
    }

    public String getOptimalSpaceAndTimeComplexity() {
        return OptimalSpaceAndTimeComplexity;
    }

    @JsonProperty("OptimalSpaceAndTimeComplexity")
    public void setOptimalSpaceAndTimeComplexity(String optimalSpaceAndTimeComplexity) {
        this.OptimalSpaceAndTimeComplexity = optimalSpaceAndTimeComplexity;
    }

    public String getSolution() {
        return Solution;
    }

    @JsonProperty("Solution")
    public void setSolution(String solution) {
        this.Solution = solution;
    }

    @Override
    public int hashCode() {
        int h = 0;
        h = 31 * h + this.Category.hashCode();
        h = 31 * h + this.SubCategory.hashCode();
        h = 31 * h + this.Difficulty.hashCode();
        h = 31 * h + this.Title.hashCode();
        h = 31 * h + this.ProblemDescription.hashCode();
        h = 31 * h + this.SampleInput.hashCode();
        h = 31 * h + this.SampleOutput.hashCode();
        h = 31 * h + this.Hints.hashCode();
        h = 31 * h + this.OptimalSpaceAndTimeComplexity.hashCode();
        h = 31 * h + this.Solution.hashCode();
        return h;
    }

    @Override
    public String toString() {
        return "QandA{" +
                "Category='" + Category + '\'' +
                ", SubCategory='" + SubCategory + '\'' +
                ", Difficulty='" + Difficulty + '\'' +
                ", Title='" + Title + '\'' +
                ", ProblemDescription='" + ProblemDescription + '\'' +
                ", SampleInput='" + SampleInput + '\'' +
                ", SampleOutput='" + SampleOutput + '\'' +
                ", Hints='" + Hints + '\'' +
                ", OptimalSpaceAndTimeComplexity='" + OptimalSpaceAndTimeComplexity + '\'' +
                ", Solution='" + Solution + '\'' +
                '}';
    }
}
