/**
 * 
 * src="<c:url value="resources/js/app.js" />"
 */

/*$(function() {*/
  $("#addMore").click(function(e) {
    e.preventDefault();
    alert("BUTTON CLICKED");
    
    $("#fieldList").append("<li>&nbsp;</li>");
    $("#fieldList").append("<li><input type='text'  placeholder='FoodItemName'  name='fooditemname'/></li>");
    $("#fieldList").append("<li><input type='text'  placeholder='description'  name='description'/></li>");
    $("#fieldList").append("<li><input type='number'  placeholder='price' name='price'/></li>");    
  });
/*});*/

      // Start indexing at the size of the current list
      

      // Add a new Address
      $("#add").click( function(e) {
    	  e.preventDefault();
    	  alert("ADD CLICKED");
          $(this).before(function() {
        	  var index =$(this).data('selector');
              var html = '<div id="addresses' + index + '.wrapper" class="hidden">';                    
              html += '<tr><td>Area:</td><td><input type="text" id="addresses' + index + '.area" name="addresses[' + index + '].area" /></br></td></tr>';
              html += '<tr><td>City:</td><td><input type="text" id="addresses' + index + '.city" name="addresses[' + index + '].city" /></br></td></tr>';
              html += '<tr><td>State:</td><td><input type="text" id="addresses' + index + '.state" name="addresses[' + index + '].state" /></br></td></tr>';
              html += '<tr><td>Zipcode:</td><td><input type="text" id="addresses' + index + '.zipcode" name="addresses[' + index + '].zipcode" /></br></td></tr>';
              html += '<input type="hidden" id="addresses' + index + '.remove" name="addresses[' + index + '].remove" value="0" />';
              html += '<button id="remove" type="button" class="addresses.remove" data-index="' + index + '">remove</button>';                    
              html += "</div>";
              return html;
          });
          $("#addresses" + index + "\\.wrapper").show();
          index++;
          return false;
      });

      // Remove an Address
      $("#remove").on('click', function(e) {
    	  e.preventDefault();
    	  alert("Remove CLICKED");
          var index2remove = $(this).data('index');
          
          $("#addresses" + index2remove + "\\.wrapper").hide();
          $("#addresses" + index2remove + "\\.remove").val("1");
          return false;
      });