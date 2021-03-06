function addNewAuthor() {
    var next = 1;
    $(".add-more-author").click(function(e){
        e.preventDefault();
        var addto = "#field" + next;
        var addRemove = "#field" + (next);
        next = next + 1;
        var newIn = '<input type="text" class="text-input new-book-authors" id="field' + next + '"  name="authors"/>';
        var newInput = $(newIn);
        var removeBtn = '<button id="remove' + (next - 1) + '" class="btn btn-danger remove-me" >-</button></div><div id="field">';
        var removeButton = $(removeBtn);
        $(addto).after(newInput);
        $(addRemove).after(removeButton);
        $("#field" + next).attr('data-source',$(addto).attr('data-source'));
        $("#count").val(next);

        $('.remove-me').click(function(e){
            e.preventDefault();
            var fieldNum = this.id.charAt(this.id.length-1);
            var fieldID = "#field" + fieldNum;
            $(this).remove();
            $(fieldID).remove();
        });
    });
}

function addNewGenre() {
    var next = 1;
    $(".add-more-genre").click(function(e){
        e.preventDefault();
        var addto = "#gfield" + next;
        var addRemove = "#gfield" + (next);
        next = next + 1;
        var newIn = '<input type="text" class="text-input new-book-genres" id="gfield' + next + '"  name="genres"/>';
        var newInput = $(newIn);
        var removeBtn = '<button id="gremove' + (next - 1) + '" class="btn btn-danger gremove-me" >-</button></div><div id="gfield">';
        var removeButton = $(removeBtn);
        $(addto).after(newInput);
        $(addRemove).after(removeButton);
        $("#gfield" + next).attr('data-source',$(addto).attr('data-source'));
        $("#count").val(next);

        $('.gremove-me').click(function(e){
            e.preventDefault();
            var fieldNum = this.id.charAt(this.id.length-1);
            var fieldID = "#gfield" + fieldNum;
            $(this).remove();
            $(fieldID).remove();
        });
    });
}