<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="org.restapi.crud.bill.model.Bill"%>
<!DOCTYPE html>
<html>
<head>
<title>Bill Form</title>
	<link rel="stylesheet" type="text/css" href="Bill.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="Views/bootstrap.min.css">
	<script src="Components/jquery-3.2.1.min.js"></script>
	<script src="Components/jquery-3.5.0.min.js"></script>
	<script src="Components/Bill.js"></script>
</head>
</head>
<body>
<img class="wave" src="img/images (22).jpg" style="width:150%;height:150%;opacity: 0.5;">

<section id="contact" style="position: absolute;top: 8%;left: 5%;right: 100%;trasform: translate(-90%,-90%);width: 1200px;height: 500;box-sizing: border-box;background: rgba(0,0,0,0.1);padding: px;"	>
            <div class="container"style="color:black;font-weight: bold;font-weight: 600;" >
                <div class="row">
                    <div class="col-md-6" style="margin-top: 50px;">
                            <div class="img">
                                <img src="img/bill.png">
                            </div>
                    </div>
                    
                    
                    <div class="col-md-6"style="color:black;font-weight: bold;font-weight: 600;" >
                        <form id="formItem" name="formItem" style="color:black;font-weight: bold;font-weight: 600;" >
                                <h1 style=" text-align: center; margin-top: 30px;color: green;font-family: 'Poppins', sans-serif;">Bill Form</h1>                               
                                <div class="form-group" style="width: 510px; margin-left: 15px;">
                                     <label for="From" style="">Enter ID No :</label>
                                     <input id="docId" style="width: 500px;margine-top: 20px;background: transparent;outline: none;padding: 20px;font-size: 13px;border-radius: 30px;box-shadow:0 0 10px #228B22;" name="docId" type="text" class="form-control" placeholder="Id No" required> 
                                </div> 
                                
                                <div class="form-group" style="width: 510px; margin-left: 15px;">
                                     <label for="From"> Enter Name :</label>
                                     <input id="docName" style="width: 500px;margine-top: 20px;background: transparent;outline: none;padding: 20px;font-size: 13px;border-radius: 30px;box-shadow:0 0 10px #228B22;" name="docName"  type="text" class="form-control" placeholder="Username" required>
                                </div>  
                                
                                <div class="form-group" style="width: 510px; margin-left: 15px;">
                                     <label for="From"> Enter Unit :</label>
                                     <input id="docUnit" style="width: 500px;margine-top: 20px;background: transparent;outline: none;padding: 20px;font-size: 13px;border-radius: 30px;box-shadow:0 0 10px #228B22;" name="docUnit"  type="text" class="form-control" placeholder="Unit" required>
                                </div>  
                                
                                <div class="form-group" style="width: 510px; margin-left: 15px;">
                                     <label for="From"> Enter Amount :</label>
                                     <input id="docAmount" style="width: 500px;margine-top: 20px;background: transparent;outline: none;padding: 20px;font-size: 13px;border-radius: 30px;box-shadow:0 0 10px #228B22;" name="docAmount"  type="text" class="form-control" placeholder="Amount" required>
                                </div> 
                                
                               
                            
                                 <div class="form-group" style="width: 510px; margin-left: 15px;">
                                      <input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-outline-success">
                                      <input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
                                </div>                     
                          
                     </form>  
                     
                     
                     <div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
                </div>
            </div>
            <br> 
               <div id="divItemsGrid" style="overflow-x:auto;">
					<%
						Bill itemObj = new Bill();
						out.print(itemObj.readBills());
					%>
            </div>
            
        </div>        
        </section>  
                    
                    
</body>
</html>