//------------------------------------------------------------------------
//                           Job table
// -----------------------------------------------------------------------
//  code       title       description      monthly       overtime
// CODESTER    Codester    dynami indi..     18000          400



//------------------------------------------------------------------------------
//							Employee
//------------------------------------------------------------------------------
// employee to no.    first name     last name       job       supervisor
//------------------------------------------------------------------------------
//      101              allan			 tan         CEO         Allan Tan



//----------------------------------------------------------------------------------------------
// 							Project
//-----------------------------------------------------------------------------------------------
//      Code          Name        Description        Client      Project Leader     start date
//-----------------------------------------------------------------------------------------------
//  RELOASSIST     ReloAssist    Relocation and..   MoveAssist    Jaycobb cruz       2009/06/01


//-------------------------------------------------------------
//				members of each project
//-------------------------------------------------------------
//     project    Members     Start Date      End Date
//-------------------------------------------------------------
//      101          JC		  2010/01/01        ------





//--------------------------------------------------------------------------------
// Answer #1
//--------------------------------------------------------------------------------

// Create and run a JavaScript function that will insert the following documents into a collection called
// “job” in a database called “mydb”. Note: use CODE values as the _id.

db.job.insertMany([
	{
	
        "_id" : "CODESTER",
        "title" : "Codester",
        "description" : "Dynamic individual who has passion for abstract and logical reasoning",
        "monthly" : 18000,
        "overtime" : 400
    },
    {
        "_id" : "CODESMITH",
        "title" : "Codesmith",
        "description" : "Crafts their codes with artistic mastery.",
        "monthly" : 28000,
        "overtime" : 800
    },
    {
        "_id" : "CODEMASTER",
        "title" : "Codemaster",
        "description" : "Chosen few who can design unique solutions to common complex problems.",
        "monthly" : 38000,
        "overtime" : 1200
    },
    {
        _id : "CODEBUSTER",
        "title" : "Code Buster",
        "description" : "Software Tester",
        "monthly" : 18000,
        "overtime" : 400
    },
    {
        "_id" : "ARTIST",
        "title" : "Graphic Artist",
        "description" : "Designing",
        "monthly" : 18000,
        "overtime" : 400
    },
    {
        "_id" : "PM",
        "title" : "Project Manager",
        "description" : "Coordinates with Project Members and Clients",
        "monthly" : 25000,
        "overtime" : 500
    },
    {
        "_id" : "CEO",
        "title" : "CEO",
        "description" : "Chief Executive Officer",
        "monthly" : 100000,
        "overtime" : 10000
    },
    { "_id" : "HR", "title" : "Human Resource", "description" : "N/A" },
    { "_id" : "ADMIN", "title" : "Office Admin", "description" : "N/A" }
]);


//--------------------------------------------------------------------------------
// Answer #2
//--------------------------------------------------------------------------------

// Create and run a JavaScript function that will insert the following documents into a collection called
// “employee”. Note: use the Employee ID Number as the _id value.


db.employee.insertMany([
	{
			"_id" : 101,
			"first_name" : "Allan",
			"last_name" : "Tan",
			"job" : "CEO",
			"supervisor" : "Allan Tan"
	},
	{
			"_id" : 102,
			"first_name" : "Rovie",
			"last_name" : "Abanes",
			"job" : "Codester",
			"supervisor" : "Philip Lim"
	},
	{
			"_id" : 103,
			"first_name" : "Daryl",
			"last_name" : "Arueno",
			"job" : "Codester",
			"supervisor" : "Philip Lim"
	},
	{
			"_id" : 104,
			"first_name" : "Sherlock",
			"last_name" : "Bactin",
			"job" : "Codemaster",
			"supervisor" : "Allan Tan"
	},
	{
			"_id" : 105,
			"first_name" : "Richard",
			"last_name" : "Buendia",
			"job" : "Codester",
			"supervisor" : "Allan Tan"
	},
	{
			"_id" : 106,
			"first_name" : "Kervi",
			"last_name" : "Cioco",
			"job" : "Graphic Artist",
			"supervisor" : "Allan Tan"
	},
	{
			"_id" : 107,
			"first_name" : "Jaycobb",
			"last_name" : "Cruz",
			"job" : "Codemaster",
			"supervisor" : "Allan Tan"
	},
	{
			"_id" : 108,
			"first_name" : "Robert",
			"last_name" : "Javier",
			"job" : "Codemaster",
			"supervisor" : "Allan Tan"
	},
	{
			"_id" : 109,
			"first_name" : "Mary",
			"last_name" : "Lim",
			"job" : "Codesmith",
			"supervisor" : "Jaycobb Cruz"
	},
	{
        "_id" : 110,
        "first_name" : "Philip",
        "last_name" : "Lim",
        "job" : "PM",
        "supervisor" : "Allan Tan"
	},
	
	{
        "_id" : 111,
        "first_name" : "Borgy",
        "last_name" : "Magdangal",
        "job" : "Code Buster",
        "supervisor" : "Jaycobb Cruz"
	},
	
	{
        "_id" : 112,
        "first_name" : "Mohammad Omair",
        "last_name" : "Marohom",
        "job" : "Codesmith",
        "supervisor" : "Jaycobb Cruz"
	},
	
	{
        "_id" : 113,
        "first_name" : "Jeric",
        "last_name" : "Morales",
        "job" : "Codester",
        "supervisor" : "Philip Lim"
	},
	
	{
        "_id" : 114,
        "first_name" : "Arjay",
        "last_name" : "Nacion",
        "job" : "Codester",
        "supervisor" : "Jaycobb Cruz"
	},
	{
        "_id" : 115,
        "first_name" : "Neil",
        "last_name" : "Namoro",
        "job" : "Codemaster",
        "supervisor" : "Allan Tan"
	},
	
	{
        "_id" : 116,
        "first_name" : "Cielo",
        "last_name" : "Navarro",
        "job" : "Code Buster",
        "supervisor" : "Niel Namoro"
	},
	
	{
        "_id" : 117,
        "first_name" : "Bea",
        "last_name" : "Perez",
        "job" : "Codesmith",
        "supervisor" : "Bea Perez"
	},
	
	{
        "_id" : 118,
        "first_name" : "Liza",
        "last_name" : "Ramos",
        "job" : "Office Admin"
	},
	
	{
        "_id" : 119,
        "first_name" : "Ellaine",
        "last_name" : "Sanchez",
        "job" : "Code Buster",
        "supervisor" : "Jaycobb Cruz"
	},
	
	{
        "_id" : 120,
        "first_name" : "JC",
        "last_name" : "Santos",
        "job" : "Codesmith",
        "supervisor" : "Jaycobb Cruz"
	},
	
	{
        "_id" : 121,
        "first_name" : "Jhoanna",
        "last_name" : "Trigo",
        "job" : "Codesmith",
        "supervisor" : "Bea Perez"
	},
	
	{
        "_id" : 122,
        "first_name" : "Samer",
        "last_name" : "Valones",
        "job" : "Codester",
        "supervisor" : "Philip Lim"
	},

	{
        "_id" : 123,
        "first_name" : "Brad",
        "last_name" : "Velena",
        "job" : "Codester",
        "supervisor" : "Philip Lim"
	},
	{
        "_id" : 124,
        "first_name" : "Auda Marie",
        "last_name" : "Parayno",
        "job" : "HR"
	}
]);

//--------------------------------------------------------------------------------
// Answer # 3
//--------------------------------------------------------------------------------

// Create and run a JavaScript function that will insert the following documents into a collection called
// “project”. Note: use the Project Code as the _id value

db.project.insertMany([
	{
		"_id" : "RELOASSIST",
		"name" : "ReloAssist" ,
		"description" : "Relocation and Moving Software",
		"client": "MoveAssist",
		"project_leader" : "Jaycobb Cruz",
		"start_date": new Date("2009/06/01")
	},
	{
		"_id" : "CMIS",
		"name" : "Case Management Information System" ,
		"description" : "Court of Appeals Case Management Information System",
		"client": "Court of Appeals Manila, CEBU & CDO",
		"project_leader" : "Neil Namorro",
		"start_date": new Date("2010/01/01")
	},
	{
		"_id" : "CMIS_CTA" ,
		"name" : "CTA Case Management Information System",
		"description" : "Court of Tax Appeals Case Management Information System",
		"client": "Court of Tax Appeals Quezon City",
		"project_leader" : "Richard Buendia",
		"start_date": new Date("2010/07/01")
	},	
	{
		"_id" : "SC2MS",
		"name" : "Small Claims Case Management System",
		"description" : "Small Claims Case Management System",
		"client": "All Philippine Regional and Municipal Courts",
		"project_leader" : "Richard Buendia",
		"start_date": new Date("2011/01/01")
	},
	{
		"_id" : "ECMT",
		"name" : "Enhanced Case Management Tool ",
		"description" : "N/A",
		"client": "OSG",
		"project_leader" : "Richard Buendia",
		"start_date": new Date("2009/10/10")
	},	
	{
		"_id" : "ZUULA",
		"name" : "Zuula",
		"description" : "Search Engine",
		"client": "Zuula",
		"project_leader" : "Bea Perez",
		"start_date": new Date("2009/01/01")
	},
	{
		"_id" : "VFLYER",
		"name" : "vFlyer",
		"description" : "N/A",
		"client": "vFlyer",
		"project_leader" : "Bea Perez",
		"start_date": new Date("2010/09/09")
	},

	{
		"_id" : "ATTACHE ",
		"name" : "Attache",
		"description" : "Case ManagementInformation System",
		"client": "DAR",
		"project_leader" : "Allan Tan",
		"start_date": new Date("2011/03/03")
    }	
]);
	
//--------------------------------------------------------------------------------
// Answer #4
//--------------------------------------------------------------------------------

// Employee's supervisor cannot be himself/herself. Create a JavaScript function to remove the
// supervisor of all employees whose supervisor is himself/herself.

db.employee.remove(
    db.employee.find(
        {
            $where : function() { return this.first_name + ' ' + this.last_name == this.supervisor }
        }
    ).pretty()
)

//--------------------------------------------------------------------------------
// Answer #5
//--------------------------------------------------------------------------------

// Create a JavaScript function to remove jobs with description “N/A” and all the employees with these
// jobs.

db.job.find().forEach( function(job_table) {
	db.employee.find( { $or : [ { job : job_table._id }, { job : job_table.title } ] }).forEach(
		function (emp) {
			if( job_table.description == "N/A" ) {
				db.employee.remove( {"_id" : emp._id });
				db.job.remove({ "_id" : job_table._id });
			}
		}
	)
})

//--------------------------------------------------------------------------------
// Answer #6
//--------------------------------------------------------------------------------

// Create a JavaScript function to change the first name of “Borgy Magdangal” to “Rogel Paulo”. Also
// “Rogel Paulo” is a Project Manager and not a Code Buster

db.employee.findAndModify({
    query: { first_name: "borgy" },
    update: { $set: { first_name: "Rogelo Paulo", job : "PM" } },
    collation: { locale: "fr", strength: 1 }
});


//--------------------------------------------------------------------------------
// Answer #7
//--------------------------------------------------------------------------------

// Create a JavaScript function to assign members to their projects. Tip: use the $addToSet update
// operator to add members to the Project document. Also, use Employee ID as reference ID. Please refer
// to the table below.


db.project.update(
	{ _id : "RELOASSIST"},
	{ $addToSet: { 
				members : { $each : [
						{
							member_id: 120,
							member_name: "JC",
							start_date: new Date("2010/01/01")
						},
						{
							member_id: 109,
							member_name: "Mary",
							start_date: new Date("2009/10/10")
						},
						{
							member_id: 111,
							member_name: "Rogel Paulo",
							start_date: new Date("2010/04/26")
						},
						{
							member_id: 112,
							member_name: "Mohammad Omair",
							start_date: new Date("2010/10/01")
						},
						{
							member_id: 114,
							member_name: "Arjay",
							start_date: new Date("2011/04/01")
						}
					]
				}
			}
	}
)

db.project.update(
	{ _id : "CMIS"},
	{ $addToSet: { 
				members : { $each : [
						{
							member_id: 116,
							member_name: "Cielo",
							start_date: new Date("2010/01/01")
						},
						{
							member_id: 119,
							member_name: "Ellaine",
							start_date: new Date("2009/03/03")
						},
						{
							member_id: 121,
							member_name: "Jhoanna",
							start_date: new Date("2010/05/10"),
							end_date: new Date("2012/07/10")
						},
						{
							member_id: 106,
							member_name: "Kervi",
							start_date: new Date("2010/03/05")
						}
					]
				}
		}
	}
)

db.project.update(
	{ _id : "CMIS_CTA"},
	{ $addToSet: { 
				members : { $each : [
						{
							member_id: 112,
							member_name: "Mohammad Omair",
							start_date: new Date("2010/06/01")
						},
						{
							member_id: 105,
							member_name: "Richard",
							start_date: new Date("2011/02/20")
						},
						{
							member_id: 120,
							member_name: "JC",
							start_date: new Date("2010/05/05"),
							end_date: new Date("07/07/10")
						},
						{
							member_id: 121,
							member_name: "Jhoanna",
							start_date: new Date("07/07/10")
						}
					]
				}
		}
	}
)

db.project.update(
	{ _id : "ECMT"},
	{ $addToSet: { 
				members : { $each : [
						{
							member_id: 105,
							member_name: "Richard",
							start_date: new Date("2010/02/03")
						},
						{
							member_id: 120,
							member_name: "JC",
							start_date: new Date("2009/04/04"),
							end_date: new Date("07/07/09")
						}
					]
				}
		}
	}
)

db.project.update(
	{ _id : "VFLYER"},
	{ $addToSet: { 
				members : { $each : [
						{
							member_id: 121,
							member_name: "Jhoanna",
							start_date: new Date("2011/01/01")
						},
						{
							member_id: 117,
							member_name: "Bea",
							start_date: new Date("2011/03/03")
						}
					]
				}
		}
	}
)