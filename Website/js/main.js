let calendar;

initCalendar();

fetch('../../src/Files/lessons.json')
.then(function(resp) {
  return resp.json();
})
.then(function(data) {
  
  data.lessons.forEach(function(item) {
    if (item.timeSlot.hourStart < 10 && item.timeSlot.hourEnd < 10) {
      addEvent({
        title: item.course.courseName + item.course.semester + item.course.className + ' - ' + item.course.teacher1.initials + ' - ' + item.room.roomNumber,
        start: '2021-12-13T0' + item.timeSlot.hourStart + ':' + item.timeSlot.minuteStart + ':00',
        end: '2021-12-13T0' + item.timeSlot.hourEnd + ':' + item.timeSlot.minuteEnd + ':00',
      })
    } else if (item.timeSlot.hourStart < 10 && item.timeSlot.hourEnd >= 10) {
      addEvent({
        title: item.course.courseName + item.course.semester + item.course.className + ' - ' + item.course.teacher1.initials + ' - ' + item.room.roomNumber,
        start: '2021-12-13T0' + item.timeSlot.hourStart + ':' + item.timeSlot.minuteStart + ':00',
        end: '2021-12-13T' + item.timeSlot.hourEnd + ':' + item.timeSlot.minuteEnd + ':00',
      })
    } else if (item.timeSlot.hourStart >= 10 && item.timeSlot.hourEnd < 10) {
      addEvent({
        title: item.course.courseName + item.course.semester + item.course.className + ' - ' + item.course.teacher1.initials + ' - ' + item.room.roomNumber,
        start: '2021-12-13T' + item.timeSlot.hourStart + ':' + item.timeSlot.minuteStart + ':00',
        end: '2021-12-13T0' + item.timeSlot.hourEnd + ':' + item.timeSlot.minuteEnd + ':00',
      })
    } else if (item.timeSlot.hourStart >= 10 && item.timeSlot.hourEnd >= 10) {
      addEvent({
        title: item.course.courseName + item.course.semester + item.course.className + ' - ' + item.course.teacher1.initials + ' - ' + item.room.roomNumber,
        start: '2021-12-13T' + item.timeSlot.hourStart + ':' + item.timeSlot.minuteStart + ':00',
        end: '2021-12-13T' + item.timeSlot.hourEnd + ':' + item.timeSlot.minuteEnd + ':00',
      })
    }
  });

});

function initCalendar() {
  let calendarEl = document.getElementById('calendar');

  calendar = new FullCalendar.Calendar(calendarEl, {

    initialView: 'dayGridMonth',

    weekNumbers: true,
    weekNumberCalculation: 'ISO',
    
    navLinks: true,
    nowIndicator: true,
    dayMaxEvents: true,
    height: 'auto',
    stickyHeaderDates: false,

    headerToolbar: {
      left: 'dayGridMonth timeGridWeek timeGridDay',
      center: 'title',
      right: 'prev,today,next'
    },
    events: [],
  });

  calendar.render();
}

function addEvent(event) {
  calendar.addEvent(event);
}