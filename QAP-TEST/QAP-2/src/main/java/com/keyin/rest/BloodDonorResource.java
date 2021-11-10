package com.keyin.rest;

import com.keyin.domain.Database;
import com.keyin.domain.donor.BloodDonor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/blood_donor")
public class BloodDonorResource {
    private Database database = new Database();

//    http://localhost:8080/blood_donor/1

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public BloodDonor getBloodDonor(@PathParam("id") int id) {
        return database.getDonor(id);
    }

}
