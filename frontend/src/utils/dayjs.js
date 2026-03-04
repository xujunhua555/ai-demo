import dayjs from 'dayjs'
import 'dayjs/locale/zh-cn'
import advancedFormat from 'dayjs/plugin/advancedFormat'
import customParseFormat from 'dayjs/plugin/customParseFormat'
import weekOfYear from 'dayjs/plugin/weekOfYear'
import weekYear from 'dayjs/plugin/weekYear'
import isoWeek from 'dayjs/plugin/isoWeek'

dayjs.extend(advancedFormat)
dayjs.extend(customParseFormat)
dayjs.extend(weekOfYear)
dayjs.extend(weekYear)
dayjs.extend(isoWeek)

dayjs.locale('zh-cn')

export default dayjs
