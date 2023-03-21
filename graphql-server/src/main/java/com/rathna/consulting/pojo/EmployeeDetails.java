package com.rathna.consulting.pojo;



import java.util.List;
import com.rathna.consulting.entity.Country;
import com.rathna.consulting.entity.Department;
import com.rathna.consulting.entity.Dependent;
import com.rathna.consulting.entity.Employee;
import com.rathna.consulting.entity.JobInfo;
import com.rathna.consulting.entity.Location;
import com.rathna.consulting.entity.Region;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EmployeeDetails {

  private Employee employee;
  private List<Dependent> dependents;
  private JobInfo job;
  private Department department;
  // public record geoDetails(Location location,Country country,Region region) {};
  private Location location;
  private Country country;
  private Region region;

}
