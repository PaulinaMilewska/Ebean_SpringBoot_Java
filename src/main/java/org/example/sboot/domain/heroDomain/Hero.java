package org.example.sboot.domain.heroDomain;

import io.ebean.Model;
import javax.persistence.*;



@MappedSuperclass
public class Hero extends Model {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int force;

    String gem; //klejnot



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  public int getForce() {
    return force;
  }

  public void setForce(int force) {
    this.force = force;
  }

  public String getGem() {
    return gem;
  }

  public void setGem(String gem) {
    this.gem = gem;
  }


}
