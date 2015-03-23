/* Copyright (C) YOOtheme GmbH, http://www.gnu.org/licenses/gpl.html GNU/GPL */

(function(nav,win,doc){if(win.matchMedia&&!nav.userAgent.match(/(iPhone|iPod|iPad)/i)){return}var bool,docElem=doc.documentElement,refNode=docElem.firstElementChild||docElem.firstChild,fakeBody=doc.createElement("body"),div=doc.createElement("div");div.id="mq-test-1";div.style.cssText="position:absolute;top:-100em";fakeBody.style.background="none";fakeBody.appendChild(div);function check(q){div.innerHTML='&shy;<style media="'+q+'"> #mq-test-1 { width: 42px; }</style>';docElem.insertBefore(fakeBody,refNode);bool=div.offsetWidth==42;docElem.removeChild(fakeBody);return bool}function update(query){var matches=check(query.media);if(query._listeners&&query.matches!=matches){query.matches=matches;for(var i=0,len=query._listeners.length;i<len;i++){query._listeners[i](query)}}}function debounce(func,wait,immediate){var timeout;return function(){var context=this,args=arguments;var later=function(){timeout=null;if(!immediate)func.apply(context,args)};var callNow=immediate&&!timeout;clearTimeout(timeout);timeout=setTimeout(later,wait);if(callNow)func.apply(context,args)}}win.matchMedia=function(q){var query,ls=[];query={matches:check(q),media:q,_listeners:ls,addListener:function(listener){if(typeof listener==="function")ls.push(listener)},removeListener:function(listener){for(var i=0,len=ls.length;i<len;i++)if(ls[i]===listener)delete ls[i]}};if(win.addEventListener){win.addEventListener("resize",debounce(function(){update(query)},150),false)}if(doc.addEventListener){doc.addEventListener("orientationchange",function(){update(query)},false)}return query}})(navigator,window,document);(function($,win,doc){if($["onMediaQuery"])return;var queries={},supported=win.matchMedia&&win.matchMedia("only all").matches;$(doc).ready(function(){for(var q in queries){var query=$(queries[q]).trigger("init");if(queries[q].matches){$(queries[q]).trigger("valid")}}});$(win).bind("load",function(){for(var q in queries){if(queries[q].matches){$(queries[q]).trigger("valid")}}});$.onMediaQuery=function(q,events){var query=q&&queries[q];if(!query){query=queries[q]=win.matchMedia(q);query.supported=supported;query.addListener(function(){$(query).trigger(query.matches?"valid":"invalid")})}$(query).bind(events);return query}})(jQuery,window,document);(function($,nav,win){$.fn.responsiveMenu=function(options){options=$.extend({current:".current"},options);return this.each(function(){var $this=$(this),target=options.target||this,select=$("<select/>"),opts="";$this.find("ul.menu").each(function(){opts+=buildOptions(this,1)});select.append(opts).change(function(){win.location.href=select.val()});select.find(options.current).attr("selected",true);if(/iPhone|iPad|iPod/.test(nav.platform)&&/OS [1-5]_[0-9_]* like Mac OS X/i.test(nav.userAgent)&&nav.userAgent.indexOf("AppleWebKit")>-1){select.find(":disabled").remove()}$this.after(select)});function buildOptions(ul,level){var opts="";$(ul).children().each(function(){var li=$(this);li.children("a, span.separator").each(function(){var element=$(this),value=element.is("a")?element.attr("href"):"",disabled=element.is("span")?" disabled":"",indent=level>1?new Array(level).join("-")+" ":"",text=element.find(".title").length?element.find(".title").text():element.text();opts+='<option value="'+value+'" class="'+element.attr("class")+'"'+disabled+">"+indent+text+"</option>";li.find("ul.level"+(level+1)).each(function(){opts+=buildOptions(this,level+1)})})});return opts}}})(jQuery,navigator,window);(function(w,nav){if(!(/iPhone|iPad|iPod/.test(nav.platform)&&/OS [1-5]_[0-9_]* like Mac OS X/i.test(nav.userAgent)&&nav.userAgent.indexOf("AppleWebKit")>-1)){return}var doc=w.document;if(!doc.querySelector){return}var meta=doc.querySelector("meta[name=viewport]"),initialContent=meta&&meta.getAttribute("content"),disabledZoom=initialContent+",maximum-scale=1",enabledZoom=initialContent+",maximum-scale=10",enabled=true,x,y,z,aig;if(!meta){return}function restoreZoom(){meta.setAttribute("content",enabledZoom);enabled=true}function disableZoom(){meta.setAttribute("content",disabledZoom);enabled=false}function checkTilt(e){aig=e.accelerationIncludingGravity;x=Math.abs(aig.x);y=Math.abs(aig.y);z=Math.abs(aig.z);if((!w.orientation||w.orientation===180)&&(x>7||(z>6&&y<8||z<8&&y>6)&&x>5)){if(enabled){disableZoom()}}else if(!enabled){restoreZoom()}}w.addEventListener("orientationchange",restoreZoom,false);w.addEventListener("devicemotion",checkTilt,false)})(this,navigator);