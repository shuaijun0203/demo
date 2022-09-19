package com.cicd.demo.repo;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.cicd.demo.entity.Employee;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@NoArgsConstructor
public class EmployeeRepo {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Employee save(Employee employee){
        dynamoDBMapper.save(employee);
        return employee;
    }

    public String update(Employee employee, String employeeID){
        DynamoDBMapperConfig dynamoDBMapperConfig = new DynamoDBMapperConfig.Builder()
                .withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
                .withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE)
                .build();

        dynamoDBMapper.save(employee,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("employeeID",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(employeeID)
                                )),dynamoDBMapperConfig);
        return employeeID;
    }

    public String updateForParts(Employee employee, String employeeID){
        DynamoDBMapperConfig dynamoDBMapperConfig = new DynamoDBMapperConfig.Builder()
                .withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
                .withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES)
                .build();

        dynamoDBMapper.save(employee,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("employeeID",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(employeeID)
                                )),dynamoDBMapperConfig);
        return employeeID;
    }

    public String delete(String employeeID){
        dynamoDBMapper.delete(dynamoDBMapper.load(Employee.class,employeeID));
        return "deleted";
    }

    public Employee getEmployeeByID(String employeeID){
        return dynamoDBMapper.load(Employee.class,employeeID);
    }

}
