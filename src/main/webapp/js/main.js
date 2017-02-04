// The root URL for the RESTful services
var rootURL = "http://localhost:8080/rest-1.0-SNAPSHOT/book";

var currentBook;

getList();

$(function() {
  $('#date').datepicker();
});
$('#btnDelete').hide();

// listeners
$('#btnPublic').click(function() {
  getList('/public');
  return false;
});

$('#btnPrivate').click(function() {
  getList('/private');
  return false;
});

$('#btnAdd').click(function() {
  newBook();
  return false;
});

$('#btnSave').click(function() {
  saveBook();
  return false;
});

$('#btnDelete').click(function() {
  deleteBook();
  return false;
});

$('#btnMove').click(function() {
  moveBook();
  return false;
});

$('#bookList a').live('click', function() {
  getByName($(this).text());
});

function newBook() {
  $('#btnDelete').hide();
  renderDetails({}); // Clean
}

function getList(catalogType) {
  console.log('getList');
  if (catalogType === undefined)
    catalogType = $('#isPrivate').is(':checked') ? '/private' : '/public';

  callAjax('GET', rootURL+catalogType, null, renderList);
}

function getByName(name) {
  console.log('getByName: ' + name);
  callAjax('GET', rootURL + '/' + name, null,
    function(data){
      $('#btnDelete').show();
      console.log('getByName success: ' + data.name);
      currentBook = data;
      renderDetails(currentBook);
    });
}

function saveBook() {
  console.log('saveBook');
  var data = formToJSON();
  if (data)
    callAjax('POST', rootURL, data,
      function(data, textStatus, jqXHR){
        $('#btnDelete').show();
        getList();
      });
  else
    alert('Book name is required');
}

function moveBook() {
  console.log('moveBook');
  $('#isPrivate').prop('checked', !$('#isPrivate').is(':checked'));
  saveBook();
}

function deleteBook() {
  console.log('deleteBook');
  callAjax('DELETE', rootURL + '/' + $('#name').val(), null,
    function(data, textStatus, jqXHR){
      alert('Book deleted successfully');
      getList();
      renderDetails({}); // Clean
    });
}

function renderList(data) {
  var list = data == null ? [] : (data instanceof Array ? data : [data]);

  $('#bookList li').remove();
  $.each(list, function(index, book) {
    $('#bookList').append('<li><a href="#" data-identity="' + book.id + '">'+book.name+'</a></li>');
  });
}

function  renderDetails(book) {
  $('#name').val(book.name);
  $('#author').val(book.author);
  $('#date').val(book.date);
  $('#isPrivate').prop('checked', book.isPrivate);
}

function formToJSON() {
  if (!$('#name').val())
    return null;
  return JSON.stringify({
    "name": $('#name').val(),
    "author": $('#author').val(),
    "date": $('#date').val(),
    "isPrivate": $('#isPrivate').is(':checked')
  });
}

function callAjax(type, url, data, success){
  $.ajax({
    type: type,
    contentType: 'application/json',
    url: url,
    dataType: 'json',
    data: data,
    success: success,
    error: ajaxError
  });
}

function ajaxError(jqXHR, textStatus, errorThrown){
  alert('Ajax call error: ' + errorThrown);
}