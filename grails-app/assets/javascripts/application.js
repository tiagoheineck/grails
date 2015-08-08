// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery-2.1.3.js
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
    (function($) {
        $('#spinner').ajaxStart(function() {
            $(this).fadeIn();
        }).ajaxStop(function() {
            $(this).fadeOut();
        });
    })(jQuery);
}

/*application.js RAILS*/

 function handleFileSelect(evt) {
    var files;
    var output = [];
    if(evt.type=='drop'){
      evt.stopPropagation();
      evt.preventDefault();
      files = evt.dataTransfer.files
    }else{
     files  = evt.target.files; // FileList object
    }
    
    document.getElementById(evt.target.dataset.outputImage).innerHTML = '';
    document.getElementById(evt.target.dataset.outputImage).style.display = 'none';
    document.getElementById(evt.target.dataset.initialImage).style.display = 'block';
    
    // Loop through the FileList and render image files as thumbnails.
    for (var i = 0, f; f = files[i]; i++) {

      // Only process image files.
      if (!f.type.match('image.*')) {
        continue;
      }
     
      var reader = new FileReader();

      // Closure to capture the file information.
      reader.onload = (function(theFile) {
        return function(e) {
          // Render thumbnail.
          /*
          var span = document.createElement('span');
          span.innerHTML = ['<img class="thumb" src="', e.target.result,
                            '" title="', escape(theFile.name), '"/>'].join('');
          document.getElementById(evt.target.dataset.outputImage).insertBefore(span, null);
          */
          var div = document.createElement('div');
          div.className = 'thumbnail';
          div.innerHTML = ['<img src="', e.target.result,'" />'].join('');
          document.getElementById(evt.target.dataset.outputImage).insertBefore(div, null);
          document.getElementById(evt.target.dataset.outputImage).style.display = 'block';
          document.getElementById(evt.target.dataset.initialImage).style.display = 'none';
          
        };
      })(f);

      // Read in the image file as a data URL.
      reader.readAsDataURL(f);
    }
      
  }
  
  $.fn.animatePrependTo = function(sel, speed) {
    var $this = this,
        newEle = $this.clone(true).prependTo(sel),
        newPos = newEle.position();
    newEle.hide();
    $this.css('position', 'absolute').animate(newPos, speed, function() {
        newEle.show();
        $this.remove();
    });
    return newEle;
};

  $.fn.animateAppendTo = function(sel, speed) {
    var $this = this,
        newEle = $this.clone(true).appendTo(sel),
        newPos = newEle.position();
    newEle.hide();
    $this.css('position', 'absolute').animate(newPos, speed, function() {
        newEle.show();
        $this.remove();
    });
    return newEle;
};


/*grids_height.js RAILS*/
(function($) {

  /**
   * Set all elements within the collection to have the same height.
   */
  $.fn.equalHeight = function(){
    var heights = [];
    $.each(this, function(i, element){
      $element = $(element);
      var element_height;
      // Should we include the elements padding in it's height?
      var includePadding = ($element.css('box-sizing') == 'border-box') || ($element.css('-moz-box-sizing') == 'border-box');
      if (includePadding) {
        element_height = $element.innerHeight();
      } else {
        element_height = $element.height();
      }
      heights.push(element_height);
    });
    this.height(Math.max.apply(window, heights));
    return this;
  };

  /**
   * Create a grid of equal height elements.
   */
  $.fn.equalHeightGrid = function(columns){
    var $tiles = this;
    $tiles.css('height', 'auto');
    for (var i = 0; i < $tiles.length; i++) {
      if (i % columns === 0) {
        var row = $($tiles[i]);
        for(var n = 1;n < columns;n++){
          row = row.add($tiles[i + n]);
        }
        row.equalHeight();
      }
    }
    return this;
  };

  /**
   * Detect how many columns there are in a given layout.
   */
  $.fn.detectGridColumns = function() {
    var offset = 0, cols = 0;
    this.each(function(i, elem) {
      var elem_offset = $(elem).offset().top;
      if (offset === 0 || elem_offset == offset) {
        cols++;
        offset = elem_offset;
      } else {
        return false;
      }
    });
    return cols;
  };

  /**
   * Ensure equal heights now, on ready, load and resize.
   */
  $.fn.responsiveEqualHeightGrid = function() {
    var _this = this;
    function syncHeights() {
      var cols = _this.detectGridColumns();
      _this.equalHeightGrid(cols);  
    }
    $(window).bind('resize load', syncHeights);
    syncHeights();
    return this;
  };

})(jQuery);